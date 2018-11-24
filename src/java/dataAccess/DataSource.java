/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Kendal Howse
 */
public class DataSource {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public void openConnection() {
//        try {
//
//            connection = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:orcl", "cst8276", "8276");
//            System.out.println("Connection successful!");
//
//        } catch (SQLException e) {
//
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//        }
        
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envCtx.lookup("jdbc/DatabaseProject");
            connection = ds.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection() {
        try {
            if(connection != null){
            connection.close();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        
    }
    
}
