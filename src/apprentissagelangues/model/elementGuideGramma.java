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
public class elementGuideGramma {
    private String grpNominal;
    private String verbe;
    private String phrase;

    public elementGuideGramma(String grpNominal, String verbe, String phrase) {
        this.grpNominal = grpNominal;
        this.verbe = verbe;
        this.phrase = phrase;
    }

    public String getGrpNominal() {
        return grpNominal;
    }

    public void setGrpNominal(String grpNominal) {
        this.grpNominal = grpNominal;
    }

    public String getVerbe() {
        return verbe;
    }

    public void setVerbe(String verbe) {
        this.verbe = verbe;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
