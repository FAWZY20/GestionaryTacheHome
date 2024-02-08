package com.example.gestinonnaryTache.model;

import jakarta.persistence.*;

@Entity
@Table(name = "NOTE")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private String user;
    @Column(name = "TITRE", nullable = false)
    private String titre;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public Note(Long id,String user, String titre, String description) {
        this.id = id;
        this.user = user;
        this.titre = titre;
        this.description = description;
    }

    public Note(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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
