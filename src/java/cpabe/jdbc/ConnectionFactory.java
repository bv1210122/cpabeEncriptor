/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cpabe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Uma fábrica de conexões Padrão.
 * @author David Buzato
 * adaptado por
 * @author BV1210122
 */
public class ConnectionFactory {

    /*
     * Este bloco estático será executado assim que esta classe for carregada,
     * sendo assim, será executado apenas uma vez.
     */
    static {
        try {
            /*
             * Carrega a classe com.mysql.jdbc.Driver, que é a implementação
             * do driver JDBC para o MySQL.
             */
            Class.forName( "com.mysql.jdbc.Driver" );

            // caso a classe não seja encontrada
        } catch ( ClassNotFoundException exc ) {

            /*
             * Como log usaremos o stacktrace das excessões.
             */
            exc.printStackTrace();

        }
    }

    /**
     * O método getConnection retorna uma conexão com a base de dados
     * testes_padroes.
     *
     * @return Uma conexão com o banco de dados testes_padroes.
     * @throws SQLException Caso ocorra algum problema durante a conexão.
     */
    public static Connection getConnection() throws SQLException {

        // o método getConnection de DriverManagaer recebe como parâmetro
        // a URL da base de dados, o usuário usado para conectar na base
        // e a senha deste usuário.
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/cpabe_bd",
                "root",
                "1234" );//informar a senha do SGBD

    }

}
