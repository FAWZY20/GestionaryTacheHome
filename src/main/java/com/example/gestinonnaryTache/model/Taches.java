package com.example.gestinonnaryTache.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TACHE")
public class Taches {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "UTILISATEUR", nullable = false)
    private String user;

    @Column(name = "TITRE", nullable = false)
    private String titre;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATEECHEANCE", nullable = false)
    private String dateFin;
    @Column(name = "STATUT", nullable = false)
    private String statut = "En_Attente";

    @Column(name = "PRIORITE", nullable = false)
    private String priorite;

    public Taches(Long id, String titre, String description, String dateFin, String statut, String user, String priorite) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dateFin = dateFin;
        this.statut = statut;
        this.user = user;
        this.priorite = priorite;
    }

    public Taches() {

    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
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

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
