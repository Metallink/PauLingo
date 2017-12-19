/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.creationDeCompte;

import apprentissagelangues.ApprentissageLangues;
import apprentissagelangues.model.UtilisateursDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Sameh EL AWADI
 */
public class CreationDeCompteController implements Initializable {

    // variables divers des éléments du FXML
    @FXML
    private JFXTextField JFXTextFieldNom;
    @FXML
    private JFXTextField JFXTextFieldPrenom;
    @FXML
    private JFXTextField JFXTextFieldIdentifiant;
    @FXML
    private JFXTextField JFXTextFieldAdresseMail;
    @FXML
    private JFXPasswordField JFXMotDePasse;
    @FXML
    private JFXPasswordField JFXMotDePasseConfirmation;
    @FXML
    private JFXButton JFXButtonValider;
    @FXML
    private JFXButton JFXButtonAnnuler;
    @FXML
    private Label labelErreur;

    // objet qui permet les interactions SQL
    UtilisateursDAO utilisateur = new UtilisateursDAO();

    // objet qui gere l'affichage des interfaces
    private ApprentissageLangues lApprentissageLangues;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /* fonction utile qui vérifie si tous les champs ont bien été rempli */
    private boolean champsVide() {
        if (JFXTextFieldNom.getText().equals("")
                || JFXTextFieldPrenom.getText().equals("")
                || JFXTextFieldIdentifiant.getText().equals("")
                || JFXTextFieldAdresseMail.getText().equals("")
                || JFXMotDePasse.getText().equals("")
                || JFXMotDePasseConfirmation.getText().equals("")) {
            labelErreur.setVisible(true);
            return true;
        } else { // si champs non vide
            labelErreur.setVisible(false);
            return false;
        }
    }
    
    // fonction qui gère l'appuie de la touche d'entrée
    @FXML
    public void appuieEntree(ActionEvent ae) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        creationCompte();
    }

    /* fonction qui compare les champs mot de passe et confirmation de mot de passe, retourne t/f s'ils correspondent */
    private boolean mdpCorrespondent() {
        boolean match;
        return (JFXMotDePasseConfirmation.getText().equals(JFXMotDePasse.getText()));
    }

    @FXML
    /* fonction qui vérifie les champs, insére l'utilisateur dans la base de données et revient au menu d'accueil*/
    private void creationCompte() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {

        if (!champsVide() && mdpCorrespondent()) { // tout est ok, on fait la requete SQL de création d'utilisateur dans la table UTILISATEURS
            // on insere l'utilisateur dans la table UTILISATEUR
            
            //System.out.println(JFXTextFieldIdentifiant.getText());
            utilisateur.insertUtilisateursCreationCompte(JFXTextFieldIdentifiant.getText(), JFXMotDePasse.getText(), JFXTextFieldNom.getText(), JFXTextFieldPrenom.getText(), JFXTextFieldAdresseMail.getText());
            
            // on retourne à la page d'accueil
            lApprentissageLangues.showContenueAccueil();
        }
    }
    
    @FXML
    /* l'utilisateur souhaite interrompre le processus de création de compte, on revient à l'écran d'accueil */
    public void retourAccueil() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        lApprentissageLangues.showContenueAccueil();
    }
    
    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        this.lApprentissageLangues = lapprentissageLangues;
    }
} 


//String pseudo, String mdp, String nom, String prenom, String mail) 