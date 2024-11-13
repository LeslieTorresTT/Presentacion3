package com.example.GameStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class GameStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GameStoreApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		//admin admin(ROLE_ADMIN)
		/*Persona persona1 = new Persona("Juan",
				"Ramirez", "Quispe",
				"923966555", "roasdca@gmail.com",
				"asdasd", "8855774",
				Date.valueOf("2024-10-13"), "M");
		repository.save(persona1);*/

		/*Persona persona2 = new Persona("Pedro",
				"Ramirez", "Quispe",
				"923966555", "asdad@gmail.com",
				"asdasd", "43350455",
				Date.valueOf("2024-10-13"), "M");
		repository.save(persona2);*/

	}
}
