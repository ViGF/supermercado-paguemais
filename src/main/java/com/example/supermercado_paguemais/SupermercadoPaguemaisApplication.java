package com.example.supermercado_paguemais;

import com.example.supermercado_paguemais.service.AdministradorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SupermercadoPaguemaisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SupermercadoPaguemaisApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AdministradorService adminService) {
		return args -> {
			adminService.criarPrimeiroAdmin();
		};
	}
}
