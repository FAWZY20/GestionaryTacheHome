package com.example.gestinonnaryTache.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "UTILISATEURS")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @Column(name = "PRENOM", nullable = false)
    private String prenom;

    @Column(name = "PASSWORD", nullable = false, length = 10)
    private String password;

    @Column(name = "MAIL", nullable = false)
    private String mail;

    @Column(name = "IMAGE")
    private String image = "https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.jpg";

    public Utilisateur(String nom, String password, String mail, String image, String prenom) {
        this.nom = nom;
        this.prenom= prenom;
        this.password = password;
        this.mail = mail;
        this.image = image;
    }

    public Utilisateur() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
