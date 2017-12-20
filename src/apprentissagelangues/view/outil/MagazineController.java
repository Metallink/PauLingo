/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.outil;

import apprentissagelangues.ApprentissageLangues;
import apprentissagelangues.model.Articles;
import apprentissagelangues.model.ArticlesDAO;
import apprentissagelangues.model.MagazinePDF;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.qoppa.pdf.PDFException;
import com.qoppa.pdfViewerFX.PDFViewer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Sameh EL AWADI
 */
public class MagazineController {

    @FXML
    private JFXListView<Articles> listviewArticles;
    @FXML
    private JFXListView<MagazinePDF> listViewMagazine;
    @FXML
    private Label labelNomArticle;
    @FXML
    private Label labelNomAuteur;
    @FXML
    private Label labelDatePublication;
    @FXML
    private JFXTextArea JFXTextAreaContenuArticle;
    @FXML
    PDFViewer pdfViewer;

    ArticlesDAO lArticleDAO = new ArticlesDAO();
    private ApprentissageLangues lApprentissageLangues;
    private String leNomLangue;
    private String uneLeçon;

    // on rempli notre listView
    ObservableList<String> data = FXCollections.observableArrayList("Vocable1", "Vocable2");

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @FXML
    public void initialize(String nomLangue) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        this.setLangue(nomLangue);
        this.pdfViewer.setToolBarVisible(true);//Sur mon interface qui permet de visionner le cours, on affiche le menu du haut.
        this.pdfViewer.setSplitVisible(false);//On désactive l'affichage qui permet de prévisualiser les fiches du cours.
        //listViewMagazine.setItems(data);
        //FIXME: voir comment creer la table article si elle n'existe pas
        if (!lArticleDAO.chargeAllArticles()) { // on n'a pas réussi à charger la table ARTICLES, on va la créer.
            lArticleDAO.createTableArticles();
            lArticleDAO.inserArticles();
            lArticleDAO.chargeAllArticles();
        }
        listviewArticles.setItems(lArticleDAO.getArticlesData());

        remplirListView(); // on remplit l'observable list d'objet magazine

        // ce qui suit permet d'afficher le premier item article de la list view dans la zone d'affichage à droite 
        // sans cela, la listview sera bien chargé mais le "focus" ne sera pas fait et donc aucun article ne sera selectionné pour être affiché
        listviewArticles.setCellFactory((ListView<Articles> p) -> {
            ListCell<Articles> cell = new ListCell<Articles>() {

                @Override
                protected void updateItem(Articles unArticle, boolean bln) {
                    super.updateItem(unArticle, bln);
                    if (unArticle != null) {
                        setText(unArticle.getNameArticle());

                        labelNomArticle.setText(unArticle.getNameArticle());
                        labelNomAuteur.setText(unArticle.getAuthorArticle());
                        labelDatePublication.setText(unArticle.getPublicationDate());
                        JFXTextAreaContenuArticle.setText(unArticle.getContentArticle());
                    }
                }

            };

            return cell;
        });

    }

    @FXML
    /* gère l'event clic sur un élément de la listview d'articles */
    public void handleMouseClickArticles(MouseEvent arg0) {

        //System.out.println("clicked on " + listviewArticles.getSelectionModel().getSelectedItem());
    }

    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        this.lApprentissageLangues = lapprentissageLangues;

    }

    public void setLangue(String unNomLangue) {
        this.leNomLangue = unNomLangue;
    }

    /* fonction qui ferme la fenetre */
    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }

    /* retour à l'interface precedente */
    @FXML
    private void eventBtnRetour() throws IOException {
        this.lApprentissageLangues.showChoixOptions(leNomLangue);
    }

    @FXML
    private void chargeContenueArticle() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        listviewArticles.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Articles>() {

            @Override
            public void changed(ObservableValue<? extends Articles> observable, Articles oldValue, Articles newValue) {
                labelNomArticle.setText(newValue.getNameArticle());
                labelNomAuteur.setText(newValue.getAuthorArticle());
                JFXTextAreaContenuArticle.setText(newValue.getContentArticle());

                labelDatePublication.setText(newValue.getPublicationDate());
            }
        });
    }

    /* prépare les données pour l'observable list */
    private ObservableList<MagazinePDF> preparationListView() {

        List<MagazinePDF> list = new ArrayList<>();

        list.add(new MagazinePDF("Vocable1", "ENG"));
        list.add(new MagazinePDF("Vocable2", "ENG"));

        ObservableList<MagazinePDF> data = FXCollections.observableList(list);

        return data;
    }

    private void remplirListView() {

        ObservableList<MagazinePDF> data = this.preparationListView(); // on récupere la l'observable list
        listViewMagazine.setItems(data);

    }

    /* fonction qui invoque setPDF() avec l'item que l'on a obtenu de la l'observable list */
    @FXML
    private void chargeContenueMagazine() throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException {
        try {
            this.setPDF(listViewMagazine.getSelectionModel().getSelectedItem().getNomPDF());
        } catch (java.lang.NullPointerException e) {
            //TODO: faire une alerte (voir une notification push dans l'idéal)
            System.out.println("Veuillez cliquer sur une cellule du tableau pour que vous puissez accéder à la leçon!");
        }
    }

    @FXML
    /* gère l'event clic sur un élément de la listview de magazine */
    public void handleMouseClickMagazine(MouseEvent arg0) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException {
        chargeContenueMagazine();
        //System.out.println("clicked on " + listviewArticles.getSelectionModel().getSelectedItem());
    }

    /* fonction qui charge le magazine que l'on a cliqué dans la listview */
    @FXML
    protected void setPDF(String nomPDF) throws MalformedURLException { //nomPDF est obtenu grâce au fonctions precedentes 

        try {
            File unPDF;
            InputStream targetStreamPDF;
            switch (nomPDF) {
                case "Vocable1":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/Vocable1.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;
                case "Vocable2":
                    unPDF = new File("src/apprentissagelangues/view/outil/filesPDF/Vocable2.pdf");
                    targetStreamPDF = new FileInputStream(unPDF);
                    this.pdfViewer.loadPDF(targetStreamPDF);
                    break;

                default:
                    break;
            }
        } catch (PDFException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
