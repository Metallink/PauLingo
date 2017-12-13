/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sameh.classes;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sameh EL AWADI
 */
public class Articles {

    private final StringProperty nameArticle;
    private final StringProperty authorArticle;
    private final ObjectProperty<LocalDate> publicationDate;
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
     */
    public Articles(String nameArticle) {
        this.nameArticle = new SimpleStringProperty(nameArticle);
      
        // Some initial dummy data, just for convenient testing.
        this.contentArticle = new SimpleStringProperty("");
        this.authorArticle = new SimpleStringProperty("");
        this.publicationDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    } 

    public Articles(String nameArticle, String authorArticle, String contentArticle, String publicationDate) {
        this.nameArticle = new SimpleStringProperty(nameArticle);
      
        // Some initial dummy data, just for convenient testing.
        this.contentArticle = new SimpleStringProperty("");
        this.authorArticle = new SimpleStringProperty("");
        this.publicationDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
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

    public LocalDate getPublicationDate() {
        return publicationDate.get();
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate.set(publicationDate);
    }

    public ObjectProperty<LocalDate> publicationDateProperty() {
        return publicationDate;
    }
    
    public String toString() {
        
        return getNameArticle();
    }
}
