/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rémy
 */
public class ArticlesDAO {
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Articles> articlesData = FXCollections.observableArrayList();

    public ArticlesDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        String nomAricle;
        String nomAuteur;
        String datePublication;
        String contenuArticle;
        //String contenuArticle = new String();

        try {
            connexionDB laConnexion = new connexionDB();
            conn = laConnexion.returnConnexion();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM ARTICLES");

            while (rs.next()) {
                
                nomAricle = rs.getString("NOMARTICLE");
                nomAuteur = rs.getString("AUTEURARTICLE");
                datePublication = rs.getString("DATEDEPUBLICATION");
                contenuArticle = rs.getString("CONTENUARTICLE");
                
                //System.out.println(nomAricle);
                //System.out.println(contenuArticle);
                //System.out.println(datePublication);
                //System.out.println(nomAuteur);
                
                articlesData.add(new Articles(nomAricle, nomAuteur, contenuArticle, datePublication));             
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
