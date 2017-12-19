/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

/**
 *
 * @author Sameh EL AWADI
 */
public class MagazinePDF {
    private String nomPDF;
    private String languePDF;

    public MagazinePDF(String nomPDF, String languePDF) {
        this.nomPDF = nomPDF;
        this.languePDF = languePDF;
    }

    public String getNomPDF() {
        return nomPDF;
    }

    public void setNomPDF(String nomPDF) {
        this.nomPDF = nomPDF;
    }

    public String getLanguePDF() {
        return languePDF;
    }

    public void setLanguePDF(String languePDF) {
        this.languePDF = languePDF;
    }
    
    /* toString nécessaire pour afficher correctement le nom de l'article dans la listview dans la partie magazine de l'app */
    public String toString() {
        return getNomPDF();
    }
}
