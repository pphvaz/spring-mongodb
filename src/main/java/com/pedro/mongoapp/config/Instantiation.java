package com.pedro.mongoapp.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedro.mongoapp.domain.Post;
import com.pedro.mongoapp.domain.User;
import com.pedro.mongoapp.dto.AuthorDTO;
import com.pedro.mongoapp.repository.PostRepository;
import com.pedro.mongoapp.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	// INJEÇÃO DOS REPOSITORIOS 
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		// LIMPEZA DAS COLEÇÕES
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		// INSTANCIACAO DOS USUARIOS
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		// INSTANCIACAO DOS POSTS ASSOCIANDO COM AUTOR
		
		Post post1 = new Post(
				null,
				sdf.parse("21/03/2018"),
				"Partiu viagem",
				"Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria)
			);
		
		Post post2 = new Post(
				null,
				sdf.parse("23/03/2018"),
				"Bom dia",
				"Acordei feliz hoje!",
				new AuthorDTO(maria)
			);
		
		// SALVANDO POSTS
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
