/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpabe.dao;

import cpabe.entidades.Atributo;
import cpabe.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para a entidade Usuário.
 *
 * @author BV1210122
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() throws SQLException {
    }

    @Override
    public void salvar(Usuario obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO "
                + "usuario( "
                + "usuario_user, "
                + "usuario_pass, "
                + "usuario_atributo ) "
                + "VALUES( ?, ?, ? );");

        stmt.setString( 1, obj.getUsuario_user() );
        stmt.setString( 2, obj.getUsuario_pass() );
        stmt.setLong( 3, obj.getUsuario_atributo().getAtributo_id() );

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar(Usuario obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE usuario "
                + "SET"
                + "    usuario_user = ?,"
                + "    usuario_pass = ?, "
                + "    usuario_atributo = ? "
                + "WHERE"
                + "    usuario_id = ?;");

        stmt.setString(1, obj.getUsuario_user());
        stmt.setString(2, obj.getUsuario_pass());
        stmt.setLong(3, obj.getUsuario_atributo().getAtributo_id());
        stmt.setLong(4, obj.getUsuario_id());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Usuario obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM usuario "
                + "WHERE"
                + "    usuario_id = ?;");

        stmt.setLong(1, obj.getUsuario_id());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {

        List<Usuario> lista = new ArrayList<Usuario>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "
                + "    u.usuario_id idUsuario, "
                + "    u.usuario_user nomeUsuario, "
                + "    u.usuario_pass senhaUsuario, "
                        
                + "    a.atributo_id idAtributo, "
                + "    a.atributo_nome nomeAtributo, "
                + "    a.atributo_descricao descricaoAtributo "
                        
                + "FROM "
                + "    usuario u, "
                + "    atributo a "
                      
               + "WHERE"
                + "    u.usuario_atributo = a.atributo_id;");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Usuario u = new Usuario();
            Atributo a = new Atributo();

            u.setUsuario_id(rs.getLong(("idUsuario")));
            u.setUsuario_user(rs.getString("nomeUsuario"));
            u.setUsuario_pass(rs.getString("senhaUsuario"));

            u.setUsuario_atributo(a);

            a.setAtributo_id(rs.getLong("idAtributo"));
            a.setAtributo_nome(rs.getString("nomeAtributo"));
            a.setAtributo_descricao(rs.getString("descricaoAtributo"));

            lista.add(u);
          
            }

            rs.close();
            stmt.close();

            return lista;

        }

        @Override
        public Usuario obterPorId
        (Long id) throws SQLException {

            Usuario u = null;

            PreparedStatement stmt = getConnection().prepareStatement(
                    "SELECT "
                + "    u.usuario_id idUsuario, "
                + "    u.usuario_user nomeUsuario, "
                + "    u.usuario_pass senhaUsuario, "
                        
                + "    a.atributo_id idAtributo, "
                + "    a.atributo_nome nomeAtributo, "
                + "    a.atributo_descricao descricaoAtributo "
                        
                + "FROM "
                + "    usuario u, "
                + "    atributo a "
                      
                + "WHERE"
                + "    u.usuario_id = ? AND "        
                + "    u.usuario_atributo = a.atributo_id;");

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

            u = new Usuario();
            Atributo a = new Atributo();

            u.setUsuario_id(rs.getLong(("idUsuario")));
            u.setUsuario_user(rs.getString("nomeUsuario"));
            u.setUsuario_pass(rs.getString("senhaUsuario"));

            u.setUsuario_atributo(a);

            a.setAtributo_id(rs.getLong("idAtributo"));
            a.setAtributo_nome(rs.getString("nomeAtributo"));
            a.setAtributo_descricao(rs.getString("descricaoAtributo"));
            }

            rs.close();
            stmt.close();

            return u;

        }
    }
