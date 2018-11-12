/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "cst8276", "8276");
            System.out.println("Connection successful!");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
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
