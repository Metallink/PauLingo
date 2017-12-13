/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sameh.vue;

import fr.sameh.classes.Articles;
import fr.sameh.classes.English;
import fr.sameh.classes.connexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sameh EL AWADI
 */
public class MainApp extends Application {

    /* variables pour drag la fenetre */
    private static double xOffset = 0;
    private static double yOffset = 0;
    private Stage primaryStage;
    English eng = new English();
    String nomAricle = new String();
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;

    private ObservableList<Articles> articlesData = FXCollections.observableArrayList();

    public MainApp() {

        try {
            connexionDB laConnexion = new connexionDB();
            conn = laConnexion.Connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT NOMARTICLE FROM ARTICLES");

            while (rs.next()) {
                nomAricle = rs.getString("NOMARTICLE");
                //System.out.println(nomAricle);
                articlesData.add(new Articles(nomAricle));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public ObservableList<Articles> getArticlesData() {
        return articlesData;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("magasine.fxml"));
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("magasine.fxml"));

        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("PauLingo");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Give the controller access to the main app.
        //MagazineController controller = loader.getController();
        //controller.setMainApp(this);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        /* on se connecte tout d'abord à la base de donnée */
        //connexionDB con = new connexionDB();

        /* on lance l'application */
        launch(args);

    }
}
