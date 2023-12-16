package com.example.gestinonnaryTache.repository;

import com.example.gestinonnaryTache.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByMail(String email);
    List<Utilisateur> findAll();
    List<Utilisateur> findByNom(String nom);

    @Query("SELECT u FROM Utilisateur u WHERE u.mail= :mail AND u.password = :password")
    Utilisateur getByMailAndPassword(@Param("mail") String mail, @Param("password") String password);
}
