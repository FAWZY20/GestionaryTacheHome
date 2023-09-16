package com.example.gestinonnaryTache.repository;

import com.example.gestinonnaryTache.model.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Taches, Long> {
    List<Taches> findByTitre(String titre);
}
