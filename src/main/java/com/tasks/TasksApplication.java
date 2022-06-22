package com.tasks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TasksApplication extends SpringBootServletInitializer implements CommandLineRunner{
//public class TasksApplication implements CommandLineRunner{
	


	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


	}

}
