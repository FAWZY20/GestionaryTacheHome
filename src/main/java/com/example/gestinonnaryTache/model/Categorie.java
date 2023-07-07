package com.example.gestinonnaryTache.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORIE", schema = "felsam")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOM_CATEGORIE", nullable = false)
    private String categorieName;

    @Column(name = "DESCRIPTION")
    private String description;

    public Categorie(Long id, String categorieName, String description) {
        this.id = id;
        this.categorieName = categorieName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
