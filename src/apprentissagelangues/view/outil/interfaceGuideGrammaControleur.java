/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.outil;
import javafx.application.HostServices;
import apprentissagelangues.ApprentissageLangues;
import apprentissagelangues.model.ElementTabLexique;
import apprentissagelangues.model.elementGuideGramma;
import apprentissagelangues.model.motLexique;
import com.qoppa.pdf.PDFException;
import com.qoppa.pdf.source.PDFSource;
import com.qoppa.pdfViewerFX.PDFViewer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Rémy
 */
public class interfaceGuideGrammaControleur implements Serializable{
    
    private ApprentissageLangues lApprentissageLangues;
    private String leNomLangue;
    
    private elementGuideGramma unElementGuideGramma;
    private ObservableList<elementGuideGramma> uneData;
    @FXML
    TableColumn columnGrpNomin;
    
    @FXML
    TableColumn columnVerbes;
    
    @FXML
    TableColumn columnPhrases;
    
    @FXML
    TableView<elementGuideGramma> tableViewGrpNomin;//un tableau égale une colonne pour pouvoir récupérer plus facilement le nom de la leçon quand
                                                   //l'utilisateur va cliquer sur une cellule.
    
    @FXML
    TableView<elementGuideGramma> tableViewVerbes;
    
    @FXML
    TableView<elementGuideGramma> tableViewPhrases;
    
    @FXML
    AnchorPane AnchorPaneLoadPDF;
    
    @FXML
    PDFViewer pdfViewer;
    
    public String uneLeçon; 
    
   @FXML
   public void initialize(String nomLangue){ 
      
    this.setLangue(nomLangue);//En fonction de la langue que l'utilisateur aura choisi, on affichera des cours approprié.
    this.colonneTabGrpNomin();//On alimente la première colonne de mon tableau avec les noms de cours lié aux groupes nominals.
    this.colonneTabVerbes();
    this.colonneTabPhrases();
    this.pdfViewer.setToolBarVisible(true);//Sur mon interface qui permet de visionner le cours, on affiche le menu du haut.
    this.pdfViewer.setSplitVisible(false);//On désactive l'affichage qui permet de prévisualiser les fiches du cours.
    tableViewGrpNomin.getSelectionModel().selectedItemProperty().addListener(new interfaceGuideGrammaControleur.RowSelectChangeListener());//On crée un évènement lorsque l'utilisateur cliquera sur une cellule de la première colonne de mon tableau.
    
    tableViewVerbes.getSelectionModel().selectedItemProperty().addListener(new interfaceGuideGrammaControleur.RowSelectChangeListener());
    
    tableViewPhrases.getSelectionModel().selectedItemProperty().addListener(new interfaceGuideGrammaControleur.RowSelectChangeListener());
    
    
   }
   
   @FXML
   private void eventBtnRetour() throws IOException{
       lApprentissageLangues.showInterfaceOutil(leNomLangue);
   }
    
    @FXML
   protected void setPDF(String nomLeçon) throws MalformedURLException{
  
       try
       {
       
            File unPDF;
            InputStream targetStreamPDF;
            switch (nomLeçon)
            {
                case "Le genre des noms": // En fonction du cours que l'utilisateur aura choisi, on chargera le PDF qui sera en rapport avec le nom du cours.
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/GenreNoms.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Pluriel des noms":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/PlurielNom.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Les adjectifs et les pronoms possessifs":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/AdjectifsPronomsPossessifs.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Le présent en BE + -ING":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/PresentBE+ING.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Le présent simple":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/PresentSimple.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Le présent perfect":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/PresentPerfect.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Le comparatif":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/LeComparatif.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Le superlatif":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/Superlatif.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Le style indirect":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/StyleIndirect.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                default:break;
            } 
       }
       catch(PDFException e)
       {
           e.printStackTrace();
       }
       catch(FileNotFoundException ex)
       {
           ex.printStackTrace();
       }
       
   }
   
   @FXML
   private void eventBtnCharger() throws MalformedURLException{//Si l'utilisateur clique sur le bouton "charger" sans avoir au préalable choisi une leçon
                                                      //une alerte sera levée.
       try
       {
            this.setPDF(this.uneLeçon);
       }
       catch(java.lang.NullPointerException e)
       {
           System.out.println("Veuillez cliquer sur une cellule du tableau pour que vous puissez accéder à la leçon!");
       }
            
       
   }
   
   private ObservableList<elementGuideGramma> getInitialTableGrpNomin() {
            
                List<elementGuideGramma> list = new ArrayList<>();
                 
                            
                list.add(new elementGuideGramma("Le genre des noms","",""));
                list.add(new elementGuideGramma("Pluriel des noms","",""));
                list.add(new elementGuideGramma("Les adjectifs et les pronoms possessifs","",""));
                
		ObservableList<elementGuideGramma> data = FXCollections.observableList(list);

		return data;
    }
   
    private void colonneTabGrpNomin(){
         ObservableList<elementGuideGramma> data = this.getInitialTableGrpNomin();
                
         
         this.columnGrpNomin.setCellValueFactory(
                               new PropertyValueFactory<ElementTabLexique,String>("grpNominal")
                          );

        
                          
         tableViewGrpNomin.setItems(data);
    }
    
    private ObservableList<elementGuideGramma> getInitialTableVerbes() {
            
                List<elementGuideGramma> list = new ArrayList<>();
                 
            
                
                list.add(new elementGuideGramma("","Le présent en BE + -ING",""));
                list.add(new elementGuideGramma("","Le présent simple",""));
                list.add(new elementGuideGramma("","Le présent perfect",""));
                
		ObservableList<elementGuideGramma> data = FXCollections.observableList(list);

		return data;
    }
   
    private void colonneTabVerbes(){
         ObservableList<elementGuideGramma> data = this.getInitialTableVerbes();
                
         
         this.columnVerbes.setCellValueFactory(
                               new PropertyValueFactory<ElementTabLexique,String>("verbe")
                          );

        
                          
         tableViewVerbes.setItems(data);
    }
    
    private ObservableList<elementGuideGramma> getInitialTablePhrases() {
            
                List<elementGuideGramma> list = new ArrayList<>();
                 
                
                list.add(new elementGuideGramma("","","Le comparatif"));
                list.add(new elementGuideGramma("","","Le superlatif"));
                list.add(new elementGuideGramma("","","Le style indirect"));
                
		ObservableList<elementGuideGramma> data = FXCollections.observableList(list);

		return data;
    }
   
    private void colonneTabPhrases(){
         ObservableList<elementGuideGramma> data = this.getInitialTablePhrases();
                
         
         this.columnPhrases.setCellValueFactory(
                               new PropertyValueFactory<ElementTabLexique,String>("phrase")
                          );

        
                          
         tableViewPhrases.setItems(data);
    }
    
   
    
    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        
        this.lApprentissageLangues = lapprentissageLangues;
       
    }
    
   public void setLangue(String unNomLangue){
       this.leNomLangue = unNomLangue;
   }
   
   
   
   
   public class RowSelectChangeListener  implements ChangeListener<elementGuideGramma> {
                
                
		public void changed(ObservableValue<? extends elementGuideGramma> ov, 
				elementGuideGramma oldVal, elementGuideGramma newVal) {
                    
                       //lorsque l'utilisateur clique sur une cellule du tableau, un objet sera récupéré et ensuite on analyse quel type de leçon il veut apprendre   

			if(newVal.getGrpNominal().length()!=0) //En fonction de la colonne dans laquelle l'utilisateur aura cliqué, on récupèrera le nom de la leçon que l'utilisateur voudra étudier.
                        {
                            
                            uneLeçon=newVal.getGrpNominal();

                            
                        }
                        else if(newVal.getVerbe().length()!=0)
                        {
                            
                            uneLeçon=newVal.getVerbe();
                            
                        }
                        else
                        {
                            uneLeçon=newVal.getPhrase();
                            
                        }
				
		}
    }
   
   @FXML
    private void handleClose() {
        System.exit(0);
    }
    
}
