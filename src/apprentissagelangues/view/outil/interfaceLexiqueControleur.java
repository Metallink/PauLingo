/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.outil;

import apprentissagelangues.ApprentissageLangues;
import apprentissagelangues.model.ElementTabLexique;
import apprentissagelangues.model.motLexique;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Rémy
 */
public class interfaceLexiqueControleur {
    
      private ApprentissageLangues lApprentissageLangues;
      private String leNomLangue;
      
      @FXML
      TableColumn columnMot;
      
      @FXML
      TableColumn columnDef;
      
      @FXML
      TableColumn columnTrad;
      
      @FXML
      TextField motRechercher;
      
      
      @FXML
      private TableView<motLexique> tabViewLexique;
      
      public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        
          this.lApprentissageLangues = lapprentissageLangues;

      }
      
      @FXML
   public void initialize(String nomlangue){
       
       this.setLangue(nomlangue); 
       this.colonneTabLexique();//On met à jour les différentes colonnes du lexique
       
       

   }
   
   private ObservableList<motLexique> getInitialTableDataLexique() {//On crée une observable liste qui contiendra les éléments 
                                                                   // qui me permettra d'alimenter mon tableau.
            
                List<motLexique> list = new ArrayList<>();
                 
            
                list.add(new motLexique("database","","base de données"));//On ajoute à ma list, les différents mots du lexique avec sa définition et sa traduction.
                list.add(new motLexique("office automation","","la bureautique"));
                list.add(new motLexique("printed circuit","","circuit imprimé"));
                list.add(new motLexique("backup","","copie de sauvegarde"));
                list.add(new motLexique("data","","données"));
                list.add(new motLexique("to erase","","effacer"));
                        
                       
                        
              
                
               
		ObservableList<motLexique> data = FXCollections.observableList(list);//On alimente mon observable liste avec la list qu'on a précédemmant créé et alimenté.

		return data;
    }
   
    private void colonneTabLexique(){
         ObservableList<motLexique> data = this.getInitialTableDataLexique();
                
         
         this.columnMot.setCellValueFactory(
                               new PropertyValueFactory<ElementTabLexique,String>("nom")//On met à jour les différentes colonnes de mon tableau grâce 
                                                                                        // à une classe où l'on aura définit des variables d'état 
                                                                                        // qui seront majoritairement de type SingleStringProperty, c'est le premier nom qui
                                                                                        // se trouve entre <> et ensuite on indique le type de variable que l'on veut dans une 
                                                                                        //colonne. Enfin, ce qui est écrit entre guillemet sa fait référence à ma classe
                                                                                        // "motLexique".
                                                                                         
                          );

           
         
         this.columnDef.setCellValueFactory(
                               new PropertyValueFactory<ElementTabLexique,String>("definition")
                          );
         
         this.columnTrad.setCellValueFactory(
                               new PropertyValueFactory<ElementTabLexique,String>("trad")
                          );
         
        
                          
         tabViewLexique.setItems(data);
    }
   
   public void setLangue(String unNomLangue){
       this.leNomLangue = unNomLangue;
   }
   
   @FXML
   private void eventBtnRechercher(){//Un event qui consiste à activer un système de recherche de mots dans un lexique.
       
       String lMotRechercher = motRechercher.getText();
       
       if(lMotRechercher.length()==0)//Si l'utilisateur ne cherche pas de mot dans le lexique mais qu'il appuie sur le bouton "rechercher".
       {
           JOptionPane.showMessageDialog(null,"Veuillez saisir le mot que vous recherchez!");
       }
       else{
           this.rechercherMotDansTableView(lMotRechercher);
       }
       
       
   }
   
   @FXML
   private void eventBtnRetour() throws IOException{
       
       lApprentissageLangues.showInterfaceOutil(leNomLangue);
       
   }
   
   private void rechercherMotDansTableView(String unMot){ //En fonction du mot que l'utilisateur recherche dans le lexique,
                                                       //cette fonction parcourera le tableau pour voir si le mot existe et
                                                       // la méthode surlignera la ligne où se trouve le mot que l'utilisateur souhaite trouver.
      
       List<String> columnNomMot = new ArrayList<>();
        for ( motLexique item : tabViewLexique.getItems()) {
           columnNomMot.add((String) this.columnMot.getCellObservableValue(item).getValue()); //On récupère tout les mots de la première colonnes du tableau.
        }
       for(int i=0; i<columnNomMot.size();i++)
       {
           if(unMot.equals(columnNomMot.get(i)))//Si le mot recherché est trouvé alors on surligne la ligne du tableau où se trouve le mot.
           {
               tabViewLexique.getSelectionModel().select(i);
               break;
           }
       }
       
       List<String> columnMotTrad = new ArrayList<>();
        for ( motLexique item : tabViewLexique.getItems()) {
           columnMotTrad.add((String) this.columnTrad.getCellObservableValue(item).getValue()); //On récupère tout les mots de la première colonnes du tableau.
        }
       for(int i=0; i<columnMotTrad.size();i++)
       {
           if(unMot.equals(columnMotTrad.get(i)))//Si le mot recherché est trouvé alors on surligne la ligne du tableau où se trouve le mot.
           {
               tabViewLexique.getSelectionModel().select(i);
               break;
           }
       }
   }
   
   @FXML
    private void handleClose() {
        System.exit(0);
    }
    
}
