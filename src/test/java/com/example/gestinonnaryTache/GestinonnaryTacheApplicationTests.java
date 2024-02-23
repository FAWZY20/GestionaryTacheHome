package com.example.gestinonnaryTache;
import com.example.gestinonnaryTache.model.Utilisateur;
import com.example.gestinonnaryTache.repository.UtilisateurRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GestinonnaryTacheApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private ObjectMapper objectMapper;

	private Utilisateur utilisateur;

	Utilisateur utilisateur1 = new Utilisateur("els","test1234","els@outlook.fr","","jlal");

	@Test
	void addUser() throws Exception {
		String jsonRequest = objectMapper.writeValueAsString(utilisateur1);
		mockMvc.perform(post("/nouveauCompte")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getUsers() throws Exception {
		mockMvc.perform(get("/users"))
				.andDo(print())
				.andExpectAll(status().isOk());
	}

}
