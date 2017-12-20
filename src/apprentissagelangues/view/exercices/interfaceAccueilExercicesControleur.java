/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.exercices;

import apprentissagelangues.ApprentissageLangues;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;

/**
 *
 * @author Rémy
 */
public class interfaceAccueilExercicesControleur {
    
    
    private ApprentissageLangues lApprentissageLangues;
    private String leNomLangue;
    
    @FXML
    public void initialize(String uneLangue){//Le paramètre contiendra le nom d'une langue afin de pouvoir proposer différentes activités en fonction 
                                             // de la langue étrangère que l'utilisateur aura choisi.
        this.setLangue(uneLangue);
    }
    
    public void setLangue(String unNomLangue){
       this.leNomLangue = unNomLangue;
   }
    
    @FXML
    private void eventBtnRetour() throws IOException {
        lApprentissageLangues.showChoixOptions(leNomLangue);
    }
    
   
   @FXML
    private void handleClose() {
        System.exit(0);
    }
    
    @FXML
    private void eventExoTexteATrou() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        lApprentissageLangues.showExerciceTexteATrou(leNomLangue);
    }
    
    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {//Une fonction utilisée par le contrôleur de base afin de 
                                                                                     //pouvoir établir une connexion entre le contrôleur de la vue
                                                                                     //et le contrôleur de base.
        
        this.lApprentissageLangues = lapprentissageLangues;
       
    }
}
