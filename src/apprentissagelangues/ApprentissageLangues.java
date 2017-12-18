/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues;

import apprentissagelangues.model.ArticlesDAO;
import apprentissagelangues.model.UtilisateursDAO;
import apprentissagelangues.view.Magazine.MagazineController;
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
    
    private FadeTransition ft;
    private String nomUtilisateur;
   
    
    //on commence par afficher l'accueil
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        this.setPrimaryStage(primaryStage); //on affecte à notre variable d'état primaryStage, une scène qui a été déjà instancié
        this.primaryStage.setTitle("ApprentissageLanguages");
        showContenueAccueil();
        
       
    }

    //on initialise une scène vide
    public void showContenueAccueil() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UtilisateursDAO lUtilisateursDAO = new UtilisateursDAO();//Permet de créar la table utilisateur et de l'alimenter lors de la première éxecution du programme
        if(!(lUtilisateursDAO.tableExist()))
        {
            lUtilisateursDAO.createTableUtilisateur();
            lUtilisateursDAO.insertUtilisateurs();
        }
       
       ArticlesDAO lArticlesDAO=new ArticlesDAO();
       if(!(lArticlesDAO.tableExist()))
        {
            lArticlesDAO.createTableArticles();
            lArticlesDAO.inserArticles();
        }
       
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ApprentissageLangues.class.getResource("view/initInterfacePlusAccueil/authentificationFXML.fxml"));
        rootLayout = (AnchorPane) loader.load();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();      
        authentificationFXMLControleur controller = loader.getController();
        controller.setApprentissageLangues(this);
        
      
    }
    
    //on alimente la scène vide avec une vue
    
   //on vide la scène et on met une nouvelle vue dans la scène  
   public void showChoixLangues() throws IOException{
            
            primaryStage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/selectionLangues/choixLanguesFXML.fxml"));
            AnchorPane unContenueChoixLangues = (AnchorPane) loader.load();//on charge la vue dans un anchor pane
            Scene scene = new Scene(unContenueChoixLangues);
            primaryStage.setScene(scene);
            ft = new FadeTransition(Duration.millis(500), unContenueChoixLangues);//on met en place une petite animation pour l'affichage de la nouvelle vue
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            primaryStage.show();
            
            
            // Give the controller access to the main app.
            choixLanguesControleur controller = loader.getController();//on lie le controller de base avec le controller de la vue 
            controller.setApprentissageLangues(this);
        
       
    }
   
   public void showChoixOptions(String nomLangue) throws IOException{
           
            primaryStage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/choixOptionsApplication/menuPrincipalChoixOptionsFXML.fxml"));
            AnchorPane unContenueChoixOptions = (AnchorPane) loader.load();
            Scene scene = new Scene(unContenueChoixOptions);
            primaryStage.setScene(scene);
            ft = new FadeTransition(Duration.millis(500), unContenueChoixOptions);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            primaryStage.show();
            // Give the controller access to the main app.
            menuPrincipalChoixOptionsControleur controller = loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);
        
       
    }
   
   public void showInterfaceOutil(String nomLangue) throws IOException{
            primaryStage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/outil/interfaceOutilFXML.fxml"));
            AnchorPane lOutil = (AnchorPane) loader.load();
            Scene scene = new Scene(lOutil);
            primaryStage.setScene(scene);
            ft = new FadeTransition(Duration.millis(500), lOutil);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            primaryStage.show();
            interfaceOutilControleur controller = loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);//on affiche la vue dans une langue spécifié par l'utilisateur lorsqu'il était sur la vue de choix des langues
        
       
    }
   
   public void showInterfaceLexique(String nomLangue) throws IOException{
            primaryStage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/outil/interfaceLexiqueFXML.fxml"));
            AnchorPane leLexique = (AnchorPane) loader.load();
            Scene scene = new Scene(leLexique);
            primaryStage.setScene(scene);
            ft = new FadeTransition(Duration.millis(500), leLexique);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            primaryStage.show();
            // Give the controller access to the main app.
            interfaceLexiqueControleur controller = loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);
        
       
    }
   
   public void showInterfaceGuideGramma(String nomLangue) throws IOException{
            primaryStage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/outil/interfaceGuideGrammaFXML.fxml"));
            AnchorPane leGuideGramma = (AnchorPane) loader.load();
            Scene scene = new Scene(leGuideGramma);
            primaryStage.setScene(scene);
            ft = new FadeTransition(Duration.millis(500), leGuideGramma);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            primaryStage.show();
            // Give the controller access to the main app.
            interfaceGuideGrammaControleur controller=loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);
        
       
    }
   
   public void showInterfaceAccueilExercices(String nomLangue) throws IOException{
            primaryStage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/exercices/interfaceAccueilExercicesFXML.fxml"));
            AnchorPane lAccueilExo = (AnchorPane) loader.load();
            Scene scene = new Scene(lAccueilExo);
            primaryStage.setScene(scene);
            ft = new FadeTransition(Duration.millis(500), lAccueilExo);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            primaryStage.show();
            // Give the controller access to the main app.
            interfaceAccueilExercicesControleur controller=loader.getController();
            
            controller.setApprentissageLangues(this);
            controller.initialize(nomLangue);
        
       
    }
   
   public void showMagazine(String nomLangue) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       primaryStage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ApprentissageLangues.class.getResource("view/Magazine/magasine.fxml"));
            AnchorPane lMagazine = (AnchorPane) loader.load();
            Scene scene = new Scene(lMagazine);
            primaryStage.setScene(scene);
            ft = new FadeTransition(Duration.millis(500), lMagazine);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            primaryStage.show();
            // Give the controller access to the main app.
            MagazineController controller=loader.getController();
            
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
