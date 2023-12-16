package com.example.gestinonnaryTache.controller;

import com.example.gestinonnaryTache.model.Taches;
import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.repository.TacheRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TacheController {

    @Autowired
    private TacheRepository tacheRepository;

    @PostMapping("/nouvelleTache")
    public void nouvelleTache(@RequestBody Taches taches){
        tacheRepository.save(taches);
    }

    @GetMapping("tache/{user}")
    public List<Taches> getTache(@PathVariable("user") String utilisateur){
        return tacheRepository.findByUser(utilisateur);
    }
}
