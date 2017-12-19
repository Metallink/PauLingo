/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.selectionLangues;

import apprentissagelangues.ApprentissageLangues;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Sameh EL AWADI
 */
public class choixLanguesControleur{

    @FXML
    private BorderPane rootPane;
    
    @FXML
    private HBox boxMenus;
    private ApprentissageLangues lApprentissageLangues;

       
   @FXML
   ImageView btnEsp;
   @FXML
   ImageView btnAllemand;
   @FXML
   ImageView btnAnglais;
   
    @FXML
    public void initialize() {
       

    }

    // fonction qui gère la fermeture de la fenetre
    @FXML
    private void handleClose() {
        System.exit(0);
    }
   
   @FXML
   private void eventBtnEsp() throws IOException{
       lApprentissageLangues.showChoixOptions(btnEsp.getId());
   }
   
   @FXML
   private void eventBtnAllemand() throws IOException{
       lApprentissageLangues.showChoixOptions(btnAllemand.getId());
   }
   
   @FXML
   private void eventBtnAnglais() throws IOException{
       lApprentissageLangues.showChoixOptions(btnAnglais.getId());
   }

    
    
    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        this.lApprentissageLangues = lapprentissageLangues;

       
    }
}
