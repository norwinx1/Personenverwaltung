package ch.bbw.model;


import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String text;
    @Temporal(TemporalType.DATE)
    private Date publication;
    private String author;

    public Article() {
        this(0, "", "", Date.from(Instant.now()), "author");
    }

    public Article(int id, String title, String text, Date publication, String author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.publication = publication;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
