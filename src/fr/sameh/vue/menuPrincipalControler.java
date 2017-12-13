/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sameh.vue;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Shinji
 */
public class menuPrincipalControler implements Initializable {

    @FXML
    private AnchorPane parentContainer;
    @FXML
    private MaterialDesignIconView iconClose;
    @FXML
    private HBox menusHolder;
    @FXML
    private AnchorPane PLANE;
    @FXML
    private Group groupPlanes;
    @FXML
    private AnchorPane TRAIN;
    @FXML
    private Group groupTrains;
    @FXML
    private AnchorPane BUS;
    @FXML
    private Group groupBuses;
    @FXML
    private AnchorPane ANALYTIC;
    @FXML
    private Group groupTrains1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void hideStage(MouseEvent event) {
    }

    @FXML
    private void openPlanes(MouseEvent event) {
    }

    @FXML
    private void openTrains(MouseEvent event) {
    }

    @FXML
    private void openBuses(MouseEvent event) {
    }

    @FXML
    private void openAnalytics(MouseEvent event) {
    }
    
}
