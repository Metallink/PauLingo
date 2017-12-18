/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rtaillandier
 */
public class UtilisateursDAO {
    
    
    private connexionDB _laConnexion = new connexionDB();
    private Statement _sta;
    
    public void createTableUtilisateur() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        _sta=laConnexion.createStatement();
        _sta.execute("CREATE TABLE UTILISATEUR" +
        "(" +
        "id INT not null primary key " +
        "GENERATED ALWAYS AS IDENTITY " +
        "(START WITH 1, INCREMENT BY 1), " +
        "pseudo VARCHAR(50), " +
        "mdp VARCHAR(50), " +
        "nom VARCHAR(50), " +
        "prenom VARCHAR(50), " +
        "mail VARCHAR(50))");
       
    }
    
    /* fonction qui permet d'inserer 2 utilisateurs "exemples" */
    public void insertUtilisateurs() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        _sta=laConnexion.createStatement();
        _sta.execute("insert into UTILISATEUR (pseudo,mdp, nom, prenom, mail) values('remy','remy', 'taillandier', 'remy', 'remy@taillandier.fr')");
        _sta.execute("insert into UTILISATEUR (pseudo,mdp, nom, prenom, mail) values('sameh','sameh', 'el awadi', 'sameh', 'sameh@elawadi.fr')");
    }
    
    /* fonction qui permet d'inserer les utilisateurs créers via l'interface "création de compte" */
    public void insertUtilisateursCreationCompte(String pseudo, String mdp, String nom, String prenom, String mail) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        _sta=laConnexion.createStatement();
        _sta.execute("insert into UTILISATEUR (pseudo,mdp,nom,prenom,mail) values('" +  pseudo + "', '" + mdp + "', '" + nom + "', '" + prenom + "', '" + mail + "')");    
    }
    
    public boolean tableExist() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        boolean exist=false;
        try (ResultSet rs = laConnexion.getMetaData().getTables(null, null, "UTILISATEUR", null)) {
            if(rs.next())
            {
                exist=true;
            }
        }

        return exist;
    }
}
