/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sameh EL AWADI
 */
public class connexionDB {

    private java.sql.Connection _laConnexion;
    private Statement _sta;

    public java.sql.Connection returnConnexion() throws SQLException{
        try {
            _laConnexion=java.sql.DriverManager.getConnection("jdbc:derby://localhost:1527/PauLingo", "root", "root");
            System.out.println("Connection success!");
            return _laConnexion;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
   
}
