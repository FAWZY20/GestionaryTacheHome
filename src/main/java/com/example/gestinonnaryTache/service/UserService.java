package com.example.gestinonnaryTache.service;

import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    private final JwtService jwtService;

    public UserService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public Utilisateur getUserByEmail(String mail) {
        return utilisateurRepository.findByMail(mail);
    }
    public String loginCheck(String mail, String pwd) {
        Utilisateur utilisateur = utilisateurRepository.getByMailAndPassword(mail, pwd) ;
        if (utilisateur != null){
            String username = utilisateur.getName();
            return jwtService.generateToken(username);
        } else {
            return "la connexion a echouer";
        }
    }
}
