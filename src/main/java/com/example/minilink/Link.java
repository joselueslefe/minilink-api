package com.example.minilink;

import jakarta.persistence.Entity;
import jakarta.persistence.Id; // IMPORTAÇÃO CORRIGIDA AQUI
import jakarta.persistence.Table;

@Entity
@Table(name = "links")
public class Link {
    @Id
    private String id;
    private String urlOriginal;
    private int cliques;

    public Link() {}

    public Link(String id, String urlOriginal) {
        this.id = id;
        this.urlOriginal = urlOriginal;
        this.cliques = 0;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public int getCliques() {
        return cliques;
    }

    public void setCliques(int cliques) {
        this.cliques = cliques;
    }
}