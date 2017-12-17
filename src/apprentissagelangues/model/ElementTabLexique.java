/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Rémy
 */
public class ElementTabLexique {
    private SimpleStringProperty nomMot;
    private SimpleStringProperty def;
    private SimpleStringProperty trad;

    public ElementTabLexique(motLexique unMotDuLexique) {
        this.nomMot = new SimpleStringProperty(unMotDuLexique.getNom());
        this.def = new SimpleStringProperty(unMotDuLexique.getDefinition());
        this.trad = new SimpleStringProperty(unMotDuLexique.getTrad());
    }
    
    
    public String getNomMot() {
        return nomMot.get();
    }

    public void setNomMot(String nomMot) {
        this.nomMot.set(nomMot);
    }

    public String getDef() {
        return def.get();
    }

    

    public void setDef(String def) {
        this.def.set(def);
    }

    public String getTrad() {
        return trad.get();
    }

    public void setTrad(String traduction) {
        this.trad.set(traduction);
    }
    
    
    
}
