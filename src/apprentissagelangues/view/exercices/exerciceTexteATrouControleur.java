/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.exercices;

import apprentissagelangues.ApprentissageLangues;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author Rémy
 */
public class exerciceTexteATrouControleur {

    private ApprentissageLangues lApprentissageLangues;
    private String leNomLangue;
    
    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        
          this.lApprentissageLangues = lapprentissageLangues;

      }
      
   @FXML
   public void initialize(String nomlangue){
       
       this.setLangue(nomlangue); 

   }
   
   public void setLangue(String unNomLangue){
       this.leNomLangue = unNomLangue;
   }
   
   @FXML
   private void handleClose() {
       System.exit(0);
   }
   
   @FXML
   private void eventBtnRetour() throws IOException{
       lApprentissageLangues.showInterfaceAccueilExercices(leNomLangue);
   }
    
    
}
