/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sameh.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sameh EL AWADI
 */
public class connexionDB {

    Connection conn = null;

    public static Connection Connect() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PauLingo", "root", "root");
            System.out.println("Connection success!");
            return conn;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
