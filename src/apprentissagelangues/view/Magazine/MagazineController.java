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
import apprentissagelangues.model.elementGuideGramma;
import apprentissagelangues.view.outil.interfaceGuideGrammaControleur;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.qoppa.pdfViewerFX.PDFViewer;
import java.io.IOException;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    ArticlesDAO lArticleDAO=new ArticlesDAO();

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
    @FXML
    private JFXListView<String>listViewMagazine;
    @FXML
    PDFViewer pdfViewer;
    ObservableList<String> data = FXCollections.observableArrayList("chocolate", "blue");


    /**
     * Initializes the controller class.
     * @param url
     */
    @FXML
    public void initialize(String nomLangue) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.setLangue(nomLangue);
        this.pdfViewer.setToolBarVisible(true);//Sur mon interface qui permet de visionner le cours, on affiche le menu du haut.
        this.pdfViewer.setSplitVisible(false);//On désactive l'affichage qui permet de prévisualiser les fiches du cours.
        listViewMagazine.setItems(data);
        lArticleDAO.chargeAllArticles();
        listviewArticles.setItems(lArticleDAO.getArticlesData());
        
        
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
    
    @FXML
    private void chargeContenueArticle() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
       
        
        
        
        
        listviewArticles.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Articles>() {

            @Override
            public void changed(ObservableValue<? extends Articles> observable, Articles oldValue, Articles newValue) {
                labelNomArticle.setText(newValue.getNameArticle());
                labelNomAuteur.setText(newValue.getAuthorArticle());
                JFXTextAreaContenuArticle.setText(newValue.getContentArticle());
                 
                 labelDatePublication.setText(newValue.getPublicationDate());
                
                
            }
        });
    }
    
    @FXML 
    private void eventBtnRetour() throws IOException{
        this.lApprentissageLangues.showChoixOptions(leNomLangue);
    }
    
    @FXML
    private void chargeContenueMagazine() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        
        
        //lArticleDAO.chargeAllArticles();
        //listViewMagazine.setItems(lArticleDAO.getArticlesData());
        
        
        /*listViewMagazine.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Articles>() {

            @Override
            public void changed(ObservableValue<? extends Articles> observable, Articles oldValue, Articles newValue) {
                
                
                
            }
        });*/
    }
    
   
}
