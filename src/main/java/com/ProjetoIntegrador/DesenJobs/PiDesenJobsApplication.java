package com.ProjetoIntegrador.DesenJobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Import; // Importe esta classe

import com.ProjetoIntegrador.DesenJobs.Configuration.CorsConfig;

@Import(CorsConfig.class) // Importe a classe CorsConfig
@SpringBootApplication
@ComponentScan(basePackages = "com.ProjetoIntegrador.DesenJobs")
public class PiDesenJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiDesenJobsApplication.class, args);
	}

}
