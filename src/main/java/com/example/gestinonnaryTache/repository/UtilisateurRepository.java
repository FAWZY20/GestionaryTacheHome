package com.example.gestinonnaryTache.repository;

import com.example.gestinonnaryTache.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByMail(String email);
    List<Utilisateur> findAll();
}
