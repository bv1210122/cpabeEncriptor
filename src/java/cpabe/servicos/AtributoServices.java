/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cpabe.servicos;

import cpabe.dao.AtributoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cpabe.entidades.Atributo;

/**
 * Classe de serviços para a entidade Atributo.
 *
 * @author BV1210122
 */
public class AtributoServices {

    /**
     * Usa o AtributoDAO para obter todos os Atributos.
     *
     * @return Lista de Atributo.
     */
    public List<Atributo> getTodos() {

        List<Atributo> lista = new ArrayList<Atributo>();
        AtributoDAO dao = null;

        try {
            dao = new AtributoDAO();
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
