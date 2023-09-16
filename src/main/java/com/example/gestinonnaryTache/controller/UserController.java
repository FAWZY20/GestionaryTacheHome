package com.example.gestinonnaryTache.controller;

import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.repository.UtilisateurRepository;
import com.example.gestinonnaryTache.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    UserService userService;
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/users")
    public List<Utilisateur> getUsers() {
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    @PostMapping("/inscrit")
    public void addUser(@RequestBody Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    @DeleteMapping("/users/{mail}")
    public void deleteUser(@PathVariable("mail") String mail){
        Utilisateur utilisateur = userService.getUserByEmail(mail);
        utilisateurRepository.deleteById(utilisateur.getId());
    }

    @PutMapping("/updateUser/{mail}")
    public void updateUser(@PathVariable("mail") String mail, @RequestBody Utilisateur utilisateurDetails){
        Utilisateur utilisateur = userService.getUserByEmail(mail);

        utilisateur.setName(utilisateurDetails.getName());
        utilisateur.setPassword(utilisateurDetails.getPassword());
        utilisateur.setMail(utilisateurDetails.getMail());

        utilisateurRepository.save(utilisateur);
    }

}
