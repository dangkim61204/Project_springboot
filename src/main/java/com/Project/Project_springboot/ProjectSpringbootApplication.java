package com.Project.Project_springboot;

import com.Project.Project_springboot.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@SpringBootApplication
public class ProjectSpringbootApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectSpringbootApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args) -> {
			storageService.init();
		};
	}




}
