package com.tasks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TasksApplication extends SpringBootServletInitializer implements CommandLineRunner{
//public class TasksApplication implements CommandLineRunner{
	


	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
	
	
	
	
	
	

}
