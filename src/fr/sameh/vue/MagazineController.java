/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sameh.vue;

import com.jfoenix.controls.JFXListView;
import fr.sameh.classes.Articles;
import fr.sameh.classes.English;
import fr.sameh.classes.dateUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Sameh EL AWADI
 */
public class MagazineController implements Initializable {
    
    English eng = new English();

    @FXML
    private JFXListView<Articles> listviewArticles;
    @FXML
    private Label labelNomArticle;
    @FXML
    private Label labelNomAuteur;
    @FXML
    private Label labelDatePublication;
    @FXML
    private TextArea labelContenuArticle;
    
    private MainApp mainap;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public MagazineController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listviewArticles.setItems(eng.getArticlesData());
        //Label.setText();
        listviewArticles.setCellFactory((ListView<Articles> p) -> {
            ListCell<Articles> cell = new ListCell<Articles>(){
                
                @Override
                protected void updateItem(Articles unArticle, boolean bln) {
                    super.updateItem(unArticle, bln);
                    if (unArticle != null) {
                        setText(unArticle.getNameArticle());
                        labelNomArticle.setText(unArticle.getNameArticle());
                        labelNomAuteur.setText(unArticle.getAuthorArticle());
                        labelDatePublication.setText(dateUtil.format(unArticle.getPublicationDate()));
                        labelContenuArticle.setText(unArticle.getContentArticle());
                    }
                }
                
            };
            
            return cell;
        }); /*http://java-buddy.blogspot.fr/2013/05/implement-javafx-listview-for-custom.html*/
            /*https://stackoverflow.com/questions/9722418/how-to-handle-listview-item-clicked-action*/
    }
    
    @FXML 
    /* gère l'event clic sur un élément de la listview de JFX */
    public void handleMouseClick(MouseEvent arg0) {
        
        System.out.println("clicked on " + listviewArticles.getSelectionModel().getSelectedItem());
    }
        

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param app
     */
    public void setMainApp(MainApp app) {
        this.mainap = app;

        // Add observable list data to the table
        listviewArticles.setItems(app.getArticlesData());
    }
    
    /* gère l'event clic sur un element de la listview 
      listviewArticles.setOnMouseClicked(event -> listviewArticles.getSelectionModel().getSelectedItem() {

        @Override
        public void handle(MouseEvent event) {
            System.out.println("clicked on " + lv.getSelectionModel().getSelectedItem());
        }
    });*/
}
