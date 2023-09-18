package com.example.gestinonnaryTache.service;

import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    public Utilisateur getUserByEmail(String mail) {
        return utilisateurRepository.findByMail(mail);
    }

}
