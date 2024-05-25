package com.serviciosconector.rest;

import com.serviciosconector.rest.models.dao.ClientDao;
import com.serviciosconector.rest.models.entity.Client;
import com.serviciosconector.rest.models.entity.ERol;
import com.serviciosconector.rest.models.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class RestApiServiciosApplication {
	//esto hay que quitarlo es una priueba para guaradar ususarios para la prueba

	public static void main(String[] args) {
		SpringApplication.run(RestApiServiciosApplication.class, args);
	}
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	ClientDao clientDao;
	CommandLineRunner init(){
		return  args -> {
			Client client = Client.builder()
					.client_email("sergio@gmail.com")
					.client_name("sergio")
					.pass(passwordEncoder.encode("21235022Rha"))
					.roles(Set.of(RoleEntity.builder().name(ERol.valueOf(ERol.ADMIN.name())).build()))
					.build();
			clientDao.save(client);
		};
	}
}
