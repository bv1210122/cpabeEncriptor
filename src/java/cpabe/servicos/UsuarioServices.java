/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cpabe.servicos;

import cpabe.dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cpabe.entidades.Usuario;

/**
 * Classe de serviços para a entidade Usuario.
 *
 * @author BV1210122
 */
public class UsuarioServices {

    /**
     * Usa o UsuarioDAOfuncionando para obter todos os usuários.
     *
     * @return Lista de usuários.
     */
    public List<Usuario> getTodos() {

        List<Usuario> lista = new ArrayList<Usuario>();
        UsuarioDAO dao = null;

        try {
            dao = new UsuarioDAO();
            lista = dao.listarTodos();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        return lista;

    }

}
