/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sameh.vue;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import fr.sameh.classes.connexionDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Sameh EL AWADI
 */
public class LoginController implements Initializable {

    /* connexion db */
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stmt = null;

    @FXML
    private JFXTextField textLogin;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void eventBtnLog() throws SQLException {
        this.loginToDB(this.textLogin.getText(), this.textPassword.getText());
    }

    @FXML
    private void loginToDB(String nickname, String password) {

        String users = new String();
        String pass = new String();

        try {
            connexionDB laConnexion = new connexionDB();
            conn = laConnexion.Connect();

            stmt = conn.createStatement();
            System.out.println("Après stmt");

            rs = stmt.executeQuery("SELECT NOMUTILISATEUR, MOTDEPASSE FROM UTILISATEURS WHERE NOMUTILISATEUR='" + nickname + "' AND MOTDEPASSE='" + password + "'");
            System.out.println("après excution requête");
            if (rs.next()) {
                users = rs.getString("NOMUTILISATEUR");
                pass = rs.getString("MOTDEPASSE");
                //System.exit(0);
            } else {
                System.out.println("Error authentification");
                labelLoginError.setVisible(true);
            }
            //System.out.println(users + " " + pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*try {
            conn = connexionDB.Connect();
            stmt = conn.createStatement();

            System.out.println("JUSQUICI TOUT VA BIEN TOUT VA BIEN");
            rs = stmt.executeQuery(query);

            System.out.println("WOOOOOOOOOOOOOHOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
            while (rs.next()) { // le while c'est pour chaque ligne du truc
                ///System.out.println(rs.getString("NOMDUTILISATEUR"));
                users = rs.getString("NOMDUTILISATEUR");
                pass = rs.getString("MOTDEPASS");
                if (users.equals(textLogin.getText()) && pass.equals(textPassword.getText())) {
                    System.out.println("LOGIN CORRECT");
                    System.exit(0);
                }
                //rs.next();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("JTE CHIE DESSUS CONNARD");
        }

        System.out.println("LOGIN INCORRECT");
        labelLoginError.setVisible(true);*/
    }
    
    @FXML
    private void keyEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
                //btnLogin.doClick();
            }
    }

    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
}
