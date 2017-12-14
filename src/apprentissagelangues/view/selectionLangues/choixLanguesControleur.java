/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.selectionLangues;

import apprentissagelangues.ApprentissageLangues;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXSnackbar;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Shinji
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
