/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpabe.dao;

import cpabe.entidades.Atributo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para a entidade Atributo.
 *
 * @author BV1210122
 */
public class AtributoDAO extends DAO<Atributo> {

    public AtributoDAO() throws SQLException {
    }

    @Override
    public void salvar(Atributo obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO "
                + "atributo( atributo_nome, atributo_descricao ) "
                + "VALUES( ?, ? );");

        stmt.setString(1, obj.getAtributo_nome());
        stmt.setString(2, obj.getAtributo_descricao());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void atualizar(Atributo obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE atributo "
                + "SET"
                + "    atributo_nome = ?,"
                + "    atributo_descricao = ? "               
                + "WHERE"
                + "    atributo_id = ?;");

        stmt.setString(1, obj.getAtributo_nome());
        stmt.setString(2, obj.getAtributo_descricao());       
        stmt.setLong(3, obj.getAtributo_id());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Atributo obj) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM atributo "
                + "WHERE"
                + "    atributo_id = ?;");

        stmt.setLong(1, obj.getAtributo_id());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public List<Atributo> listarTodos() throws SQLException {

        List<Atributo> lista = new ArrayList<Atributo>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * FROM atributo;");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Atributo atributo = new Atributo();


            atributo.setAtributo_id(rs.getLong("atributo_id"));
            atributo.setAtributo_nome(rs.getString("atributo_nome"));
            atributo.setAtributo_descricao(rs.getString("atributo_descricao"));
            

            lista.add(atributo);

        }

        rs.close();
        stmt.close();

        return lista;

    }

    @Override
    public Atributo obterPorId(Long id) throws SQLException {

        Atributo atributo = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * FROM atributo "
                + "WHERE atributo_id = ?;");

        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            atributo = new Atributo();

            atributo.setAtributo_id(rs.getLong("atributo_id"));
            atributo.setAtributo_nome(rs.getString("atributo_nome"));
            atributo.setAtributo_descricao(rs.getString("atributo_descricao"));
        }

        rs.close();
        stmt.close();

        return atributo;

    }
}
