/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

/**
 *
 * @author Rémy
 */
public class motLexique {
   
    private String nom;
    private String definition;
    private String trad;
    
    public motLexique(String nom, String definition, String trad){
        this.nom=nom;
        this.definition=definition;
        this.trad=trad;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getTrad() {
        return trad;
    }

    public void setSynonyme(String trad) {
        this.trad = trad;
    }
    
    
    
    
}
