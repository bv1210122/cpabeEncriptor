/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpabe.controladores;

import cpabe.dao.UsuarioDAO;
import cpabe.entidades.Atributo;
import cpabe.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para tratar Usuário.
 *
 * @author BV1210122
 */
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        UsuarioDAO dao = null;
        RequestDispatcher disp = null;

        try {

            dao = new UsuarioDAO();

            if (acao.equals("cadastrar")) {

                String usuario_user = request.getParameter("usuario_user");
                String usuario_pass = request.getParameter("usuario_pass");
                Long usuario_atributo = Long.parseLong(request.getParameter("usuario_atributo"));

                Usuario usuario = new Usuario();
                
                Atributo a = new Atributo();
                a.setAtributo_id(usuario_atributo);

                usuario.setUsuario_user(usuario_user);
                usuario.setUsuario_pass(usuario_pass);
                usuario.setUsuario_atributo(a);
                
                dao.salvar(usuario);

                disp = request.getRequestDispatcher(
                        "/formularios/usuario/listagem.jsp");

            } else if (acao.equals("alterar")) {

                Long usuario_id = Long.parseLong(request.getParameter("usuario_id"));
                String usuario_user = request.getParameter("usuario_user");
                String usuario_pass = request.getParameter("usuario_pass");
                Long usuario_atributo = Long.parseLong(request.getParameter("usuario_atributo"));

                Usuario usuario = new Usuario();
                
                Atributo a = new Atributo();
                a.setAtributo_id(usuario_atributo);
               
                usuario.setUsuario_id(usuario_id);
                usuario.setUsuario_user(usuario_user);
                usuario.setUsuario_pass(usuario_pass);
                usuario.setUsuario_atributo(a);

                dao.atualizar(usuario);

                disp = request.getRequestDispatcher(
                        "/formularios/usuario/listagem.jsp");

            } else if (acao.equals("excluir")) {

                Long usuario_id = Long.parseLong(request.getParameter("usuario_id"));

                Usuario usuario = new Usuario();
                usuario.setUsuario_id(usuario_id);

                dao.excluir(usuario);

                disp = request.getRequestDispatcher(
                        "/formularios/usuario/listagem.jsp");

            } else if (acao.equals("prepAlteracao")) {

                Long usuario_id = Long.parseLong(request.getParameter("usuario_id"));
                Usuario usuario = dao.obterPorId(usuario_id);
                request.setAttribute("usuario", usuario);

                disp = request.getRequestDispatcher(
                        "/formularios/usuario/alterar.jsp");

            } else if (acao.equals("prepExclusao")) {

                Long usuario_id = Long.parseLong(request.getParameter("usuario_id"));
                Usuario usuario = dao.obterPorId(usuario_id);
                request.setAttribute("usuario", usuario);

                disp = request.getRequestDispatcher(
                        "/formularios/usuario/listarexclusao.jsp");

            } else if (acao.equals("listarUsuarioID")) {

                Long usuario_id = Long.parseLong(request.getParameter( "usuario_id" ) );
                Usuario usuario = dao.obterPorId(usuario_id);
                request.setAttribute( "usuario", usuario );

                disp = request.getRequestDispatcher(
                        "/formularios/usuario/listaUsuarioID.jsp");
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

        if (disp != null) {
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
        processRequest(request, response);
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
        processRequest(request, response);
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
