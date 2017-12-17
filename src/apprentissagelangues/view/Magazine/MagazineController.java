/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.Magazine;

import apprentissagelangues.ApprentissageLangues;
import apprentissagelangues.model.Articles;
import apprentissagelangues.model.ArticlesDAO;
import apprentissagelangues.model.dateUtil;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Sameh EL AWADI
 */
public class MagazineController {
    
    ArticlesDAO lArticleDAO;

    @FXML
    private JFXListView<Articles> listviewArticles;
    @FXML
    private Label labelNomArticle;
    @FXML
    private Label labelNomAuteur;
    @FXML
    private Label labelDatePublication;
    @FXML
    private JFXTextArea JFXTextAreaContenuArticle;
    
    private ApprentissageLangues lApprentissageLangues;
    private String leNomLangue;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public MagazineController() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.lArticleDAO = new ArticlesDAO();
    }

    /**
     * Initializes the controller class.
     * @param url
     */
    
    public void initialize(String nomLangue) {
        this.setLangue(nomLangue);
        listviewArticles.setItems(lArticleDAO.getArticlesData());
        
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
                        JFXTextAreaContenuArticle.setText(unArticle.getContentArticle());
                    }
                }
                
            };
            
            return cell;
        });
    }
    
    @FXML 
    /* gère l'event clic sur un élément de la listview de JFX */
    public void handleMouseClick(MouseEvent arg0) {
        
        System.out.println("clicked on " + listviewArticles.getSelectionModel().getSelectedItem());
    }
        

    
    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        this.lApprentissageLangues = lapprentissageLangues;

       
    }
    
    public void setLangue(String unNomLangue){
       this.leNomLangue = unNomLangue;
   }
    
    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
    
    /* gère l'event clic sur un element de la listview 
      listviewArticles.setOnMouseClicked(event -> listviewArticles.getSelectionModel().getSelectedItem() {

        @Override
        public void handle(MouseEvent event) {
            System.out.println("clicked on " + lv.getSelectionModel().getSelectedItem());
        }
    });*/
}
