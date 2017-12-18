/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprentissagelangues.model;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rémy
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

    /**
     * Constructor with some initial data.
     *
     *
     * @param nameArticle
     */
    public Articles(String nameArticle) {
        this.nameArticle = new SimpleStringProperty(nameArticle);

        // Some initial dummy data, just for convenient testing.
        this.contentArticle = new SimpleStringProperty("");
        this.authorArticle = new SimpleStringProperty("");
        this.publicationDate = new SimpleStringProperty("");
        //this.publicationDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public Articles(String nameArticle, String authorArticle, String contentArticle, String publicationDate) {
        this.nameArticle = new SimpleStringProperty(nameArticle);

        // Some initial dummy data, just for convenient testing.
        this.contentArticle = new SimpleStringProperty(contentArticle);
        this.authorArticle = new SimpleStringProperty(authorArticle);
        this.publicationDate = new SimpleStringProperty(publicationDate);
        //this.publicationDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

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

    
    public String toString() {
        return getNameArticle();
    }
}
