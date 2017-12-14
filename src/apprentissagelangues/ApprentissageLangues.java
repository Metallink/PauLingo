/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues;

import apprentissagelangues.model.UtilisateursDAO;
import apprentissagelangues.view.initInterfacePlusAccueil.initInterfaceFXML;
import apprentissagelangues.view.choixOptionsApplication.menuPrincipalChoixOptionsControleur;
import apprentissagelangues.view.exercices.interfaceAccueilExercicesControleur;
import apprentissagelangues.view.initInterfacePlusAccueil.authentificationFXMLControleur;
import apprentissagelangues.view.outil.interfaceGuideGrammaControleur;
import apprentissagelangues.view.outil.interfaceOutilControleur;
import apprentissagelangues.view.outil.interfaceLexiqueControleur;
import apprentissagelangues.view.selectionLangues.choixLanguesControleur;

import java.io.IOException;
import java.sql.SQLException;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author rtaillandier
 */
public class ApprentissageLangues extends Application {
    
    private Stage primaryStage;
    private AnchorPane rootLayout;
    @FXML
   
    private FadeTransition ft;
    private String nomUtilisateur;
   
    
    //on commence par afficher l'accueil
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        primaryStage.setResizable(false);
        this.setPrimaryStage(primaryStage); //on affecte à notre variable d'état primaryStage, une scène qui a été déjà instancié
        this.primaryStage.setTitle("ApprentissageLanguages");
        initAccueil();
        this.showContenueAccueil();
       
    }

    //on initialise une scène vide
    public void initAccueil() throws IOException, SQLException {
       // UtilisateursDAO lUtilisateursDAO = new UtilisateursDAO();//Permet de créar la table utilisateur et de l'alimenter
       //lUtilisateursDAO.createTableUtilisateur();
       //lUtilisateursDAO.insertUtilisateurs();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ApprentissageLangues.class.getResource("view/initInterfacePlusAccueil/initInterfaceFXML.fxml"));
        rootLayout = (AnchorPane) loader.load();
        Scene scene = new Scene(rootLayout);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
      
    }
    
    //on alimente la scène vide avec une vue
    public void showContenueAccueil() throws IOException{
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/initInterfacePlusAccueil/authentificationFXML.fxml"));
            
            
            AnchorPane unAuthentificateur = (AnchorPane) loader.load();
            
           primaryStage.setHeight(586);
            primaryStage.setWidth(1077);
            rootLayout.getChildren().add(unAuthentificateur);
            
           
           
            // Give the controller access to the main app.
        authentificationFXMLControleur controller = loader.getController();
        controller.setApprentissageLangues(this);
       
    }
    
   //on vide la scène et on met une nouvelle vue dans la scène  
   public void showChoixLangues() throws IOException{
            primaryStage.setHeight(510); //on redimensionne la scène pour que la vue puisse s'afficher entièrement
            primaryStage.setWidth(800);
            rootLayout.getChildren().clear(); //on vide la scène
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/selectionLangues/choixLanguesFXML.fxml"));
            AnchorPane unContenueChoixLangues = (AnchorPane) loader.load();//on charge la vue dans un anchor pane
            
            rootLayout.getChildren().add(unContenueChoixLangues);//on met la nouvelle vue dans la scène vide
            ft = new FadeTransition(Duration.millis(500), unContenueChoixLangues);//on met en place une petite animation pour l'affichage de la nouvelle vue
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            // Give the controller access to the main app.
        choixLanguesControleur controller = loader.getController();//on lie le controller de base avec le controller de la vue 
        controller.setApprentissageLangues(this);
        
       
    }
   
   public void showChoixOptions(String nomLangue) throws IOException{
            primaryStage.setHeight(800);
            primaryStage.setWidth(1371);
            rootLayout.getChildren().clear();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/choixOptionsApplication/menuPrincipalChoixOptionsFXML.fxml"));
            AnchorPane unContenueChoixOptions = (AnchorPane) loader.load();
            rootLayout.getChildren().add(unContenueChoixOptions);
            ft = new FadeTransition(Duration.millis(500), unContenueChoixOptions);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            // Give the controller access to the main app.
            menuPrincipalChoixOptionsControleur controller = loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);
        
       
    }
   
   public void showInterfaceOutil(String nomLangue) throws IOException{
            primaryStage.setHeight(640);
            primaryStage.setWidth(830);
            rootLayout.getChildren().clear();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/outil/interfaceOutilFXML.fxml"));
            AnchorPane lOutil = (AnchorPane) loader.load();
            rootLayout.getChildren().add(lOutil);
            ft = new FadeTransition(Duration.millis(500), lOutil);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            // Give the controller access to the main app.
            interfaceOutilControleur controller = loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);//on affiche la vue dans une langue spécifié par l'utilisateur lorsqu'il était sur la vue de choix des langues
        
       
    }
   
   public void showInterfaceLexique(String nomLangue) throws IOException{
            primaryStage.setHeight(850);
            primaryStage.setWidth(982);
            rootLayout.getChildren().clear();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/outil/interfaceLexiqueFXML.fxml"));
            AnchorPane leLexique = (AnchorPane) loader.load();
            rootLayout.getChildren().add(leLexique);
            ft = new FadeTransition(Duration.millis(500), leLexique);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            // Give the controller access to the main app.
            interfaceLexiqueControleur controller = loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);
        
       
    }
   
   public void showInterfaceGuideGramma(String nomLangue) throws IOException{
            primaryStage.setHeight(840);
            primaryStage.setWidth(1397);
            rootLayout.getChildren().clear();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/outil/interfaceGuideGrammaFXML.fxml"));
            AnchorPane leGuideGramma = (AnchorPane) loader.load();
            rootLayout.getChildren().add(leGuideGramma);
            ft = new FadeTransition(Duration.millis(500), leGuideGramma);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            // Give the controller access to the main app.
            interfaceGuideGrammaControleur controller=loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);
        
       
    }
   
   public void showInterfaceAccueilExercices(String nomLangue) throws IOException{
            primaryStage.setHeight(745);
            primaryStage.setWidth(964);
            rootLayout.getChildren().clear();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/exercices/interfaceAccueilExercicesFXML.fxml"));
            AnchorPane lAccueilExo = (AnchorPane) loader.load();
            rootLayout.getChildren().add(lAccueilExo);
            ft = new FadeTransition(Duration.millis(500), lAccueilExo);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            // Give the controller access to the main app.
            interfaceAccueilExercicesControleur controller=loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);
        
       
    }
    
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    
     public String getNomUtilisateur() {
        return nomUtilisateur;
    }
    
    
    private void setPrimaryStage(Stage pStage) {
        if(pStage==null)
        {
            System.out.println("Elle est à nulle la variable mise en paramètre");
        }
        else
        {
            this.primaryStage = pStage;
        }
        
    }
   

    public static void main(String[] args) {
        launch(args);
    }
    
}
