/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class BaseDAO {

    protected Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Onde está seu PostgreSQL JDBC Driver? "
                    + "Inclua-o ao Build Path!");
            e.printStackTrace();
        }
    }

    public BaseDAO() {
        connection = null;
        System.out.println("-------- PostgreSQL "
                + "JDBC Teste de Conexão ------------");

        System.out.println("PostgreSQL JDBC Driver Registrado!");

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/coursera", "postgres",
                    "dan");

        } catch (SQLException e) {
            System.out.println("Conexão falhou! Verifique a saída no console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("Tudo pronto para trabalhar!");
        } else {
            System.out.println("Falha ao tentar conexão!");
        }
    }
}
