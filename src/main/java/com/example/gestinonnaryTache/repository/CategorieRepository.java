package com.example.gestinonnaryTache.repository;

import com.example.gestinonnaryTache.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
