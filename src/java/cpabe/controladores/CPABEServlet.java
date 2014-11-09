/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpabe.controladores;

import cpabe.dao.AtributoDAO;
import cpabe.dao.UsuarioDAO;
import cpabe.entidades.Atributo;
import cpabe.entidades.ExecutarShell;
import cpabe.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para tratar Criptografia CPABE.
 *
 * @author BV1210122
 */
public class CPABEServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String acao = request.getParameter("acao");
        UsuarioDAO dao = new UsuarioDAO();
        AtributoDAO daoAtri = new AtributoDAO();
        RequestDispatcher disp = null;

        try {

            dao = new UsuarioDAO();
            daoAtri = new AtributoDAO();
            ExecutarShell exe = new ExecutarShell();

            if (acao.equals("gerar_chave_privada")) {

                Long usuario_id = Long.parseLong(request.getParameter("usuario_id"));

                Usuario usuario = dao.obterPorId(usuario_id);
                request.setAttribute("usuario", usuario);

                String nome_chave = usuario.getUsuario_user();
                String atributo_chave = usuario.getUsuario_atributo().getAtributo_nome();

                exe.executeCommand("/home/aluno/cpabe-0.11/cpabe-keygen -o /home/aluno/cpabe-0.11/users_keys/" + nome_chave + "_pk /home/aluno/cpabe-0.11/system_keys/pub_key /home/aluno/cpabe-0.11/system_keys/master_key " + atributo_chave + "");
      
                // informar o caminho do Tomcat para efetuar a cópia da chave de modo a permitir o Download para o usuário
                exe.executeCommand("cp /home/aluno/cpabe-0.11/users_keys/" + nome_chave + "_pk /home/aluno/path/to/tomcat/tmpfiles");
 
                String fileName = nome_chave + "_pk";

                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Gerar Chave Privada</title>");
                    out.println("</head>");
                    out.println("<body style=\"background-color: gray;\">");
                    out.println("<div style=\"background-color: #D3D3D3; align:center; text-align:left; border: 10px solid; border-color:black; margin:10%; \">");
                    out.println("<h1 style=\"color:#0000CD; text-align:center;\">Gerar Chave Privada via " + request.getContextPath() + "</h1>");
                    out.println("<p>Chave Gerada com Sucesso para " + nome_chave + "!</p>");
                    out.println("<p>O atributo " + atributo_chave + " foi vinculado à Chave Privada gerada!</p>");
                    out.println("<p style=\"text-align:center;\"><a href=\"UploadDownloadFileServlet?fileName=" + fileName + "\">Download da Chave Privada: " + fileName + "</a></p>");
                    out.println("<p style=\"color:#FF0000;\">Atenção: Esta chave é pessoal e intransferível. Guarde-a em local seguro, pois sem ela não conseguirá descriptografar.</p>");
                    out.println("<br>");
                    out.println("<a href='index.jsp' >Voltar à Página Inicial</a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }

            } else if (acao.equals("criptografar")) {

                Long atributo_id = Long.parseLong(request.getParameter("atributo_id"));
                String fileName = request.getParameter("fileName");
                String caminho = request.getParameter("arquivo");

                System.out.println(fileName);
                System.out.println(caminho);
                Atributo atributo = daoAtri.obterPorId(atributo_id);

                String atributo_nome = atributo.getAtributo_nome();
                System.out.println(atributo_nome);

                exe.executeCommand("/home/aluno/cpabe-0.11/cpabe-enc /home/aluno/cpabe-0.11/system_keys/pub_key " + caminho + " " + atributo_nome + "");

                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Criptografar</title>");
                    out.println("</head>");
                    out.println("<body style=\"background-color: gray;\">");
                    out.println("<div style=\"background-color: #D3D3D3; align:center; text-align:left; border: 10px solid; border-color:black; margin:10%; \">");
                    out.println("<h1 style=\"color:#0000CD; text-align:center;\">Criptografar via " + request.getContextPath() + "</h1>");
                    out.println("<h4>Arquivo criptografado com Sucesso!</h4>");
                    out.println("<p>" + fileName + " criptografado com o(s) atributo(s) " + atributo_nome + "</p>");
                    out.println("<p style=\"text-align:center;\"><a href=\"UploadDownloadFileServlet?fileName=" + fileName + ".cpabe\">Download do Arquivo Criptografado: " + fileName + ".cpabe</a></p>");
                    out.println("<br>");
                    out.println("<a href='index.jsp' class='btn btn-primary'>Voltar à Página Inicial</a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }

            } else if (acao.equals("descriptografar")) {

                String caminho = request.getParameter("arquivo_criptografado");
                String aux = request.getParameter("fileName");
                String fileName = aux.substring(0, aux.length() - 6);
                String chave_privada = request.getParameter("chave_privada");

                System.out.println(caminho);
                System.out.println(chave_privada);

                exe.executeCommand("/home/aluno/cpabe-0.11/cpabe-dec /home/aluno/cpabe-0.11/system_keys/pub_key " + chave_privada + " " + caminho + "");

                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Descriptografar</title>");
                    out.println("</head>");                    
                    out.println("<body style=\"background-color: gray;\">");
                    out.println("<div style=\"background-color: #D3D3D3; align:center; text-align:left; border: 10px solid; border-color:black; margin:10%; \">");
                    out.println("<h1 style=\"color:#0000CD; text-align:center;\">Descriptografar via " + request.getContextPath() + "</h1>");
                    out.println("<h4>Comando de descriptografia executado com Sucesso!</h4>");
                    out.println("<p>Arquivo a ser descriptografado: " + caminho + "</p>");
                    out.println("<p>Utilizando a Chave Privada: " + chave_privada + "</p>");
                    out.println("<p style=\"text-align:center;\"><a href=\"UploadDownloadFileServlet?fileName=" + fileName + "\">Download do Arquivo Descriptografado: " + fileName + "</a></p>");
                    out.println("<br>");
                    out.println("<p style=\"color:#FF0000;\">ATENÇÃO: O DOWNLOAD somente ocorrerá se o arquivo tiver sido descriptografado com sucesso. Caso contrário aparecerá uma mensagem de erro acerca da inexistência do arquivo no servidor.</p>");
                    out.println("<p style=\"color:#FF0000;\">LEMBRETE: A decodificação não ocorrerá se a CHAVE PRIVADA não possuir os atributos necessários, definidos no momento da criptografia do arquivo!</p>");
                    out.println("<br>");
                    out.println("<a href='index.jsp' class='btn btn-primary'>Voltar à Página Inicial</a></button>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
        }

        if (disp
                != null) {
            disp.forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CPABEServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CPABEServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
