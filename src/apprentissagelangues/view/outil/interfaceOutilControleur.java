/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.view.outil;

import apprentissagelangues.ApprentissageLangues;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

/**
 *
 * @author Rémy
 */
public class interfaceOutilControleur {

    private ApprentissageLangues lApprentissageLangues;
    private String leNomLangue;
    
    @FXML
    RadioButton btnRadioLexique;
    
    @FXML
    RadioButton btnRadioGramma;
    
   
    
    public void setApprentissageLangues(ApprentissageLangues lapprentissageLangues) {
        
        this.lApprentissageLangues = lapprentissageLangues;
       
    }
    
   @FXML
   public void initialize(String nomLangue){
    this.setLangue(nomLangue);

   }
   
   @FXML
   private void eventBtnRetour() throws IOException{
       lApprentissageLangues.showChoixOptions(leNomLangue);
   }
   
    @FXML
   private void eventBtnValider() throws IOException{
       if(btnRadioGramma.isSelected())
       {
           this.lApprentissageLangues.showInterfaceGuideGramma(leNomLangue);
       }
       else if(btnRadioLexique.isSelected())
       {
           this.lApprentissageLangues.showInterfaceLexique(leNomLangue);
       }
   }
   
   @FXML
   private void eventBtnRadioLexique(){
       if(btnRadioGramma.isSelected())
       {
           btnRadioGramma.setSelected(false);
       }
   }
   
   @FXML
   private void eventBtnRadioGramma(){
       if(btnRadioLexique.isSelected())
       {
           btnRadioLexique.setSelected(false);
       }
   }
   
   public void setLangue(String unNomLangue){
       this.leNomLangue = unNomLangue;
   }
   
   @FXML
    private void handleClose() {
        System.exit(0);
    }
    
}
