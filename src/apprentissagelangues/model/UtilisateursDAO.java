/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rtaillandier
 */
public class UtilisateursDAO {
    
    
    private connexionDB _laConnexion = new connexionDB();
    private Statement _sta;
    
    public void createTableUtilisateur() throws SQLException{
         java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        _sta=laConnexion.createStatement();
        _sta.execute("CREATE TABLE UTILISATEUR" +
        "(" +
        "id INT not null primary key " +
        "GENERATED ALWAYS AS IDENTITY " +
        "(START WITH 1, INCREMENT BY 1), " +
        "pseudo VARCHAR(50), " +
        "mdp VARCHAR(50))");
       
    }
    
    public void insertUtilisateurs() throws SQLException{
        java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        _sta=laConnexion.createStatement();
        _sta.execute("insert into UTILISATEUR (pseudo,mdp) values('remy','remy')");
        _sta.execute("insert into UTILISATEUR (pseudo,mdp) values('sameh','sameh')");
        
    }
}
