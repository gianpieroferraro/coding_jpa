package com.coding.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.coding.jpa.models.Author;
import com.coding.jpa.repositories.AuthorRepository;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//creaimo un bean e nei parametri facciamo la injection di AuthorRepository che sarà la injectato
	//questo bean sarà lanciato quando avviamo l'applicazione 
	@Bean	//per disabilitarlo basta commentare questa annotation
	public CommandLineRunner commandLineRunner(AuthorRepository repository) {

		return args -> {
			/* 'var' consente di dichiarare una variabile con un tipo implicito, che viene dedotto dal compilatore in base al valore 
			assegnato alla variabile */
			var author = Author.builder()
				.firstName("Gianpiero")
				.lastName("ferry")
				.age(29)
				.email("stoca@ali.com")
			.build();

			//usiamo la repository per salvarlo nel db
			repository.save(author); /* quando facciamo save, passiamo dallo stato transient a Persinsent gestito da hibernate(vedi 
			schema -> comunqeu tutto il processo viene fatto da hibernate sottobanco per noi) tutto questo è una transazione,
			 ma bisongna capire qual è il lifecycle di una Entity
			**schema entityLifecicle.png**
			*/

		};



	}
}
