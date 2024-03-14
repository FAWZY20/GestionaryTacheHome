package com.example.gestinonnaryTache.service;

import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Utilisateur getUserById(long id) {
        return utilisateurRepository.findById(id);
    }

    public ResponseEntity<?> loginCheck(String mail, String pwd) {
        Utilisateur utilisateur = utilisateurRepository.getByMailAndPassword(mail, pwd) ;
        try {
            String tokenInfo = utilisateur.getMail();
            String token = jwtService.generateToken(tokenInfo);

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
