package com.example.gestinonnaryTache.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TACHES", schema = "felsam")
public class Taches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITRE", nullable = false)
    private String titre;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_CREATION", nullable = false)
    private Date dateCreation;

    @Column(name = "DATE_FIN", nullable = false)
    private Date dateFin;

    @Column(name = "STATUT", nullable = false)
    private String statut = "en attente";

    @Column(name = "USERID", nullable = false)
    private Long userId;


    public Taches(Long id, String titre, String description, Date dateCreation, Date dateFin, String statut, Long userId) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateFin = dateFin;
        this.statut = statut;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
