package com.example.gestinonnaryTache.model;


import jakarta.persistence.*;

@Entity
@Table(name = "USERAUTH")
public class UserAuthentification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
    @Column(name = "ID_USERAUTH", nullable = false)
    private String id;
    @Column(name = "MAIL", nullable = false)
    private String mail;

    @Column(name = "PASSWORD", nullable = false, length = 10)
    private String password;


    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

}
