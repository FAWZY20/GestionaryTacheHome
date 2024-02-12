package com.example.gestinonnaryTache.service;

import com.example.gestinonnaryTache.model.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMessage(Utilisateur utilisateur) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(utilisateur.getMail());
        message.setSubject("Voici votre compte GererMaMaisonEasy");

        String body = buildEmailBody(utilisateur);
        message.setText(body);

        javaMailSender.send(message);
    }

    public String buildEmailBody(Utilisateur utilisateur){
        String body = "Bonjour "+ utilisateur.getPrenom() +",\n" +
                "\n" +
                "Votre compte a été créé avec succès. Voici vos informations de connexion :\n" +
                "\n" +
                "Nom d'utilisateur : "+ utilisateur.getMail() +"\n" +
                "Mot de passe : "+ utilisateur.getPassword() +"\n" +
                "\n" +
                "Gardez ces informations en sécurité et n'hésitez pas à nous contacter si vous avez des questions.\n" +
                "\n" +
                "Bien à vous,";
        return body;
    }

}
