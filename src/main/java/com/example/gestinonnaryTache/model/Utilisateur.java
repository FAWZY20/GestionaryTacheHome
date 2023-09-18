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

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false, length = 10)
    private String password;

    @Column(name = "MAIL", nullable = false)
    private String mail;

    public Utilisateur(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public Utilisateur() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
