package com.example.gestinonnaryTache;

import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.repository.UtilisateurRepository;
import com.example.gestinonnaryTache.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class GestinonnaryTacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestinonnaryTacheApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UtilisateurRepository userRepository, UserService userService) {
		return args -> {
			//creation de 5 utilisateur
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Utilisateur utilisateur = new Utilisateur(name,"093270", name.toLowerCase() + "@domain.com");
				userRepository.save(utilisateur);
			});

			//afficher tout les utilisateur
			userRepository.findAll().forEach(System.out::println);

			//modifier un utilisateur en fonction de sont email
			Utilisateur utilisateur = userService.getUserByEmail("john@domain.com");

			utilisateur.setName("test");
			utilisateur.setPassword("test");
			utilisateur.setMail("test");

			userRepository.save(utilisateur);

			//supprimer un utilisateur en fonction de sont email
			userService.getUserByEmail("john@domain.com");
			userRepository.deleteById(utilisateur.getId());
		};
	}

}
