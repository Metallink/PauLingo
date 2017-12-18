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
    
    ResultSet rs = null;
    private connexionDB _laConnexion = new connexionDB();
    private Statement _sta;

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Articles> articlesData = FXCollections.observableArrayList();

    public void chargeAllArticles()throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        String nomAricle;
        String nomAuteur;
        String datePublication;
        String contenuArticle;
        //String contenuArticle = new String();

        try {
            
            java.sql.Connection laConnexion=_laConnexion.returnConnexion();
            _sta = laConnexion.createStatement();
            rs = _sta.executeQuery("SELECT NOMARTICLE,AUTEURARTICLE,DATEDEPUBLICATION,CONTENUARTICLE  FROM ARTICLES");

            while (rs.next()) {
                
                nomAricle = rs.getString("NOMARTICLE");
                nomAuteur = rs.getString("AUTEURARTICLE");
                datePublication = rs.getString("DATEDEPUBLICATION");
                contenuArticle = rs.getString("CONTENUARTICLE");
                
                
                /*System.out.println(nomAricle);
                System.out.println(contenuArticle);
                System.out.println(datePublication);
                System.out.println(nomAuteur);*/
                
                articlesData.add(new Articles(nomAricle, nomAuteur, contenuArticle, datePublication)); 
                
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
            e.printStackTrace();
        }       
    }
    
    public void createTableArticles() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        _sta=laConnexion.createStatement();
        _sta.execute("CREATE TABLE ARTICLES" +
        "(" +
        "NOMARTICLE VARCHAR(100),\n" +
        "AUTEURARTICLE VARCHAR(100),\n" +
        "DATEDEPUBLICATION DATE,\n" +
        "CONTENUARTICLE VARCHAR(2000))");
       
    }
    
    public void inserArticles() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        _sta=laConnexion.createStatement();
        _sta.execute("INSERT INTO articles (NOMARTICLE, AUTEURARTICLE, DATEDEPUBLICATION, CONTENUARTICLE) \n" +
        "VALUES ('The Coldest Village in the World', 'Sophie Millet', '2017-12-03', 'Oymyakon is a Russian town that people claim is the coldest inhabited place on Earth. It lies far in Siberia’s Yakutia region where temperatures drop below minus 60.\n" +
        "\n" +
        "One man says that it has been like this for years, explaining that when he was in school, it was minus 60 or 61 every year and now it stays like that for at least ten days in a row.\n" +
        "\n" +
        "Oymyakon has another record—the Yakutian horse, which is small but perfectly formed and very hardy.')"); 
        
        _sta.execute("INSERT INTO articles (NOMARTICLE, AUTEURARTICLE, DATEDEPUBLICATION, CONTENUARTICLE) \n" +
        "VALUES ('Titanosaur in New York', 'Sophie Millet', '2017-12-05', 'In New York’s American Museum of Natural History, there is a giant herbivore Titanosaur spanning 37 metres. It is so big that it cannot even fit inside the institute’s fossil hall – its long neck and head poke out of the room, offering a surprise greeting to visitors.\n" +
        "\n" +
        "Palaeontologists think that the dinosaur, which roamed the forests around 100 million years ago, would have weighed about 70 tonnes; that is the weight of ten elephants. People first discovered the species in 2014 in Argentina’s Patagonia region.\n" +
        "\n" +
        "Palaeontologists excavated the Titanosaur in the Argentinian desert after a rancher gave them a tip, who noticed the fossils on his land. The Titanosaur was temporarily on display in New York, and around five million visitors come to the museum each year, proving that dinosaurs are still proper celebrities.'\n" +
        ")");
        
        _sta.execute("INSERT INTO articles (NOMARTICLE, AUTEURARTICLE, DATEDEPUBLICATION, CONTENUARTICLE) \n" +
         "VALUES ('Small Nice Animal', 'Sophie Millet', '2017-12-07', 'An owner of a tiny hedgehog filmed the animal cleaning herself, and now Nuala is a sensation on the Internet. The owner is happy about the attention, but she does not want  people to rush out to get hedgehogs of their own.\n" +
         "\n" +
         "Hedgehogs are more high-maintenance than other small animals like hamsters or guinea pigs, as they need more care and attention. If you want one of these animals, make sure to understand how you will be caring for it!'\n" +
         ")");
    }
    
    public boolean tableExist() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        java.sql.Connection laConnexion=_laConnexion.returnConnexion();
        boolean exist=false;
        try (ResultSet rs = laConnexion.getMetaData().getTables(null, null, "ARTICLES", null)) {
            if(rs.next())
            {
                exist=true;
            }
        }

        return exist;
    }
    
    /**
     * Returns the data as an observable list of Articles. 
     * @return
     */
    public ObservableList<Articles> getArticlesData() {
        return articlesData;
    }
}
