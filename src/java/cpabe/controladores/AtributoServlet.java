/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpabe.controladores;

import cpabe.dao.AtributoDAO;
import cpabe.entidades.Atributo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para tratar Atributo.
 *
 * @author BV1210122
 */
public class AtributoServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {

        String acao = request.getParameter("acao");
        AtributoDAO dao = new AtributoDAO();
        RequestDispatcher disp = null;

        try {

            dao = new AtributoDAO();

            if (acao.equals("cadastrar")) {

                String atributo_nome = request.getParameter("atributo_nome");
                String atributo_descricao = request.getParameter("atributo_descricao");

                Atributo atributo = new Atributo();

                atributo.setAtributo_nome(atributo_nome);
                atributo.setAtributo_descricao(atributo_descricao);

                dao.salvar(atributo);

                disp = request.getRequestDispatcher(
                        "/formularios/atributo/listagem.jsp");

            } else if (acao.equals("alterar")) {

                Long atributo_id = Long.parseLong(request.getParameter("atributo_id"));
                String atributo_nome = request.getParameter("atributo_nome");
                String atributo_descricao = request.getParameter("atributo_descricao");

                Atributo atributo = new Atributo();

                atributo.setAtributo_id(atributo_id);
                atributo.setAtributo_nome(atributo_nome);
                atributo.setAtributo_descricao(atributo_descricao);

                dao.atualizar(atributo);

                disp = request.getRequestDispatcher(
                        "/formularios/atributo/listagem.jsp");

            } else if (acao.equals("excluir")) {

                Long atributo_id = Long.parseLong(request.getParameter("atributo_id"));

                Atributo atributo = new Atributo();
                atributo.setAtributo_id(atributo_id);

                dao.excluir(atributo);

                disp = request.getRequestDispatcher(
                        "/formularios/atributo/listagem.jsp");

            } else if (acao.equals("prepAlteracao")) {

                Long atributo_id = Long.parseLong(request.getParameter("atributo_id"));
                Atributo atributo = dao.obterPorId(atributo_id);
                request.setAttribute("atributo", atributo);

                disp = request.getRequestDispatcher(
                        "/formularios/atributo/alterar.jsp");

            } else if (acao.equals("prepExclusao")) {

                Long atributo_id = Long.parseLong(request.getParameter("atributo_id"));
                Atributo atributo = dao.obterPorId(atributo_id);
                request.setAttribute("atributo", atributo);

                disp = request.getRequestDispatcher(
                        "/formularios/atributo/listarexclusao.jsp");

            } else if (acao.equals("listarAtributoID")) {

                Long atributo_id = Long.parseLong(request.getParameter( "atributo_id" ) );
                Atributo atributo = dao.obterPorId(atributo_id);
                request.setAttribute( "atributo", atributo );

                disp = request.getRequestDispatcher(
                        "/formularios/atributo/listaAtributoID.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AtributoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AtributoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
