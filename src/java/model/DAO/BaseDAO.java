/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public BaseDAO() {
        connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/coursera", "postgres",
                    "dan");

        } catch (Exception e) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
