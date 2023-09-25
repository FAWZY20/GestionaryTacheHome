package com.example.gestinonnaryTache.controller;

import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.service.JwtService;
import com.example.gestinonnaryTache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {
    @Autowired
    UserService userService;
    private final JwtService jwtService;

    public UserAuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login-success")
    public String loginSuccess(@RequestBody Utilisateur checkUtilisateur) {
        return userService.loginCheck(checkUtilisateur.getMail(), checkUtilisateur.getPassword());
    }

}
