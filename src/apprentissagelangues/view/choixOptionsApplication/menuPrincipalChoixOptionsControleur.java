/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.choixOptionsApplication;

import apprentissagelangues.ApprentissageLangues;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Sameh EL AWADI
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
    Label labelBienvenue;

    @FXML
    public void initialize(String unNomLangue) {
        //On utilise la méthode initialize pour modifier, dès que la vue s'affiche, les composantes de la vue.
        //J'ai mis en paramètre un string qui contiendra la langue que l'utilisateur voudra apprendre,
        //afin de pouvoir modifier les boutons mais plus précisément le nom des boutons.
        this.setLangue(unNomLangue); //On met à jour la variable d'état "leNomLangue".
        if (unNomLangue.compareTo("btnAnglais") == 0) {
            labelBienvenue.setText("Welcome");
        } else if (unNomLangue.compareTo("btnEsp") == 0) {
            labelBienvenue.setText("Bienvenido");
            unNomUtilisateur.setLayoutX(880);
        } else { // il ne reste plus que l'allemand
             labelBienvenue.setText("Wilkommen");
             unNomUtilisateur.setLayoutX(905);
        }
            
        this.unNomUtilisateur.setText(lApprentissageLangues.getNomUtilisateur() + "!");//on met à jour un label qui sera à droite du "Welcome", afin
        //de pouvoir dire à l'utilisateur dans différentes langues, bonjour lorsqu'il arrive sur l'application.

    }

    @FXML
    private void eventBtnRetour() throws IOException {
        lApprentissageLangues.showChoixLangues();
    }

    public void setLangue(String unNomLangue) {
        this.leNomLangue = unNomLangue;
    }

    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        this.lApprentissageLangues = lapprentissageLangues;
    }

    @FXML
    private void eventBtnOutil() throws IOException {
        lApprentissageLangues.showInterfaceOutil(leNomLangue);
    }

    @FXML
    private void eventBtnMagazin() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        lApprentissageLangues.showMagazine(leNomLangue);
    }

    @FXML
    private void eventBtnAtelier() throws IOException {
        lApprentissageLangues.showInterfaceAccueilExercices(leNomLangue);
    }

    @FXML
    private void handleClose() {//l'event du bouton pour sortir de l'application
        System.exit(0);
    }

}
