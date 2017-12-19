/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sameh EL AWADI
 */
public class Articles {

    private final StringProperty nameArticle;
    private final StringProperty authorArticle;
    private final StringProperty publicationDate;
    private final StringProperty contentArticle;

    /**
     * Default constructor.
     */
    public Articles() {
        this(null);
    }

    /* constructeurs*/
    public Articles(String nameArticle) {
        this.nameArticle = new SimpleStringProperty(nameArticle);

        // Some initial dummy data, just for convenient testing.
        this.contentArticle = new SimpleStringProperty("");
        this.authorArticle = new SimpleStringProperty("");
        this.publicationDate = new SimpleStringProperty("");
    }

    public Articles(String nameArticle, String authorArticle, String contentArticle, String publicationDate) {
        this.nameArticle = new SimpleStringProperty(nameArticle);

        // Some initial dummy data, just for convenient testing.
        this.contentArticle = new SimpleStringProperty(contentArticle);
        this.authorArticle = new SimpleStringProperty(authorArticle);
        this.publicationDate = new SimpleStringProperty(publicationDate);
    }

    /* GETTERS/SETTERS */
    public String getAuthorArticle() {
        return authorArticle.get();
    }

    public void setAuthorArticle(String authorArticle) {
        this.authorArticle.set(authorArticle);
    }

    public StringProperty authorArticleProperty() {
        return authorArticle;
    }

    public String getContentArticle() {
        return contentArticle.get();
    }

    public void setContentArticle(String contentArticle) {
        this.contentArticle.set(contentArticle);
    }

    public StringProperty contentArticleProperty() {
        return contentArticle;
    }

    public String getNameArticle() {
        return nameArticle.get();
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle.set(nameArticle);
    }

    public StringProperty nameArticleProperty() {
        return nameArticle;
    }

    public String getPublicationDate() {
        return publicationDate.get();
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate.set(publicationDate);
    }

    /* toString nécessaire pour afficher correctement le nom de l'article dans la listview dans la partie magazine de l'app */
    public String toString() {
        return getNameArticle();
    }
}
