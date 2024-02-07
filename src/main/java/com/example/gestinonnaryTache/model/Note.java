package com.example.gestinonnaryTache.model;

import jakarta.persistence.*;

@Entity
@Table(name = "NOTE")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "TITRE", nullable = false)
    private String titre;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "USER_ID", nullable = false)
    private String user;

    public Note(String user, String titre, String description) {
        this.user = user;
        this.titre = titre;
        this.description = description;
    }

    public Note(){}

    public String getUser_id() {
        return user;
    }

    public void setUser_id(String user) {
        this.user = user;
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
}
