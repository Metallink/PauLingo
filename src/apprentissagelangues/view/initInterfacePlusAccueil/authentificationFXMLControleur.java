/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.initInterfacePlusAccueil;

import apprentissagelangues.ApprentissageLangues;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import apprentissagelangues.model.connexionDB;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 *
 */
public class authentificationFXMLControleur {

    /* connexion db */
    java.sql.Connection conn = null;
    java.sql.ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stmt = null;

    @FXML
    private ImageView loginText;
    @FXML
    private JFXTextField leLogin;
    @FXML
    private JFXPasswordField textPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private Label labelLoginError;
    @FXML
    private JFXButton btnSignUp;
    @FXML
    private Label labelExitProgram;
    private ApprentissageLangues lApprentissageLangues;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        
    }
    
    @FXML
    private void eventBtnLog() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        this.loginToDB(this.leLogin.getText(),this.textPassword.getText());
    }

   
    private void loginToDB(String pseudo, String mdp) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException  {

        
        String users=new String();
        String pass=new String();
        try{
            connexionDB laConnexion=new connexionDB();
            conn = laConnexion.returnConnexion();
            
            stmt = conn.createStatement();
           
           
            rs = stmt.executeQuery("SELECT pseudo,mdp FROM UTILISATEUR WHERE pseudo='"+pseudo+"' AND mdp='"+mdp+"'");
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Identification correct.");
                lApprentissageLangues.setNomUtilisateur(pseudo);
                lApprentissageLangues.showChoixLangues();
            }
            else
            {
                labelLoginError.setVisible(true);
            }
            
            
        }catch(SQLException e){
            e.printStackTrace();
        } 

    }

    @FXML
    private void handleClose() {
        System.exit(0);
    }
    
    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        this.lApprentissageLangues = lapprentissageLangues;

       
    }
}
