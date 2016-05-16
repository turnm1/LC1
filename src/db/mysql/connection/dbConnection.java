/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Turna
 */
public class dbConnection {
    
    
   public static void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
      connection();
        String serverName = "localhost";
        String mydatabase = "aal_test";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
        String username = "doctor";
        String password = "doctorpw";
    
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.print("haha");
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
