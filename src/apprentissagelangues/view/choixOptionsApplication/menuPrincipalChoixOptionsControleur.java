/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.choixOptionsApplication;

import apprentissagelangues.ApprentissageLangues;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Shinji
 */
public class menuPrincipalChoixOptionsControleur {

    /**
     * Initializes the controller class.
     */
    
    private ApprentissageLangues lApprentissageLangues;
    
    private String leNomLangue;
    
    @FXML
    Label labelDecouvrir;
    
    @FXML
    Label labelExercice;
    
    
    @FXML
    Label labelApprendre;
    
    @FXML
    Label unNomUtilisateur;
    
    @FXML
    public void initialize(String unNomLangue) { //On utilise la méthode initialize pour modifier, dès que la vue s'affiche, les composantes de la vue.
                                                //J'ai mis en paramètre un string qui contiendra la langue que l'utilisateur voudra apprendre,
                                                //afin de pouvoir modifier les boutons mais plus précisément le nom des boutons.
        this.setLangue(unNomLangue);//On met à jour la variable d'état "leNomLangue". 
        this.unNomUtilisateur.setText(lApprentissageLangues.getNomUtilisateur()+"!");//on met à jour un label qui sera à droite du "Welcome", afin
                                                        //de pouvoir dire à l'utilisateur dans différentes langues, bonjour lorsqu'il arrive sur l'application.
       
    } 
    
    @FXML
    private void eventBtnRetour() throws IOException{
        lApprentissageLangues.showChoixLangues();
    }
    
    public void setLangue(String unNomLangue){
       this.leNomLangue = unNomLangue;
   }
    
     public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        this.lApprentissageLangues = lapprentissageLangues;
     }
     
   @FXML
   private void eventBtnOutil() throws IOException{
       lApprentissageLangues.showInterfaceOutil(leNomLangue);
   }
   
   @FXML
   private void eventBtnMagazin() throws IOException{
       lApprentissageLangues.showMagazine(leNomLangue);
   }
   
   @FXML
   private void eventBtnAtelier() throws IOException{
       lApprentissageLangues.showInterfaceAccueilExercices(leNomLangue);
   }
   
   @FXML
    private void handleClose() {//l'event du bouton pour sortir de l'application
        System.exit(0);
    }
    
}
