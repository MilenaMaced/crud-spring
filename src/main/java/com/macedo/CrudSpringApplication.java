package com.macedo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.macedo.enums.Category;
import com.macedo.model.Course;
import com.macedo.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
		
	}
	@Bean
	CommandLineRunner initDatabase( CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();
			Course c =  new Course();
			c.setName("Angular");
			c.setCategory(Category.FRONT_END);

			courseRepository.save(c);
		};
	}
}
