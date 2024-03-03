package com.example.gestinonnaryTache.controller;

import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.repository.UtilisateurRepository;
import com.example.gestinonnaryTache.service.EmailService;
import com.example.gestinonnaryTache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/users")
    public List<Utilisateur> getUsers() {
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    @GetMapping("/usersByMail/{mail}")
    public Utilisateur getUserByEmail(@PathVariable("mail") String mail) {
        return utilisateurRepository.findByMail(mail);
    }

    @GetMapping("/famille/{nom}")
    public List<Utilisateur> getFamille(@PathVariable("nom") String nom){
        return utilisateurRepository.findByNom(nom);
    }

    @PostMapping("/nouveauCompte")
    public void addUser(@RequestBody Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") long id){
        utilisateurRepository.deleteById(id);
    }

    @PutMapping("/updateUser/{mail}")
    public void updateUser(@PathVariable("mail") String mail, @RequestBody Utilisateur utilisateurDetails){
        Utilisateur utilisateur = userService.getUserByEmail(mail);

        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setPrenom(utilisateurDetails.getPrenom());
        utilisateur.setImage(utilisateurDetails.getImage());
        utilisateur.setPassword(utilisateurDetails.getPassword());
        utilisateur.setMail(utilisateurDetails.getMail());

        utilisateurRepository.save(utilisateur);
    }


    @PostMapping("/newUserFamilly")
    public void createUserFamily(@RequestBody Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
        emailService.sendSimpleMessage(utilisateur);
    }


}
