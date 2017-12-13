/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sameh.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Sameh EL AWADI
 */
public class English {

    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Articles> articlesData = FXCollections.observableArrayList();

    public English() {
        
        String nomAricle = new String();
        String nomAuteur = new String();
        String datePublication = new String();
        String contenuArticle = new String();

        try {
            connexionDB laConnexion = new connexionDB();
            conn = laConnexion.Connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM ARTICLES");

            while (rs.next()) {
                nomAricle = rs.getString("NOMARTICLE");
                nomAuteur = rs.getString("AUTEURARTICLE");
                datePublication = rs.getString("DATEDEPUBLICATION");
                contenuArticle = rs.getString("CONTENUARTICLE");
                //System.out.println(contenuArticle);
                //System.out.println(datePublication);
                //System.out.println(nomAuteur);
                
                articlesData.add(new Articles(nomAricle));
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
            e.printStackTrace();
        }       
    }
    
    
    /**
     * Returns the data as an observable list of Articles. 
     * @return
     */
    public ObservableList<Articles> getArticlesData() {
        return articlesData;
    }
}
