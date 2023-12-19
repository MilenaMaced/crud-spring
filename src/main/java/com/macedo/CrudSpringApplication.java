package com.macedo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.macedo.enums.Category;
import com.macedo.model.Course;
import com.macedo.model.Lesson;
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

			Lesson l1 = new Lesson();
			l1.setName("Aula 1");
			l1.setYoutubeUrl("https://youtu.be/Nb4uxLxdvxo?si=oqaCXuSs2gPDBvIH");
			l1.setCourse(c);
			c.getLessons().add(l1);

			Lesson l2 = new Lesson();
			l2.setName("Aula 2");
			l2.setYoutubeUrl("https://youtu.be/Nb4uxLxdvxo?si=oqaCXuSs2gPDBvIH");
			l2.setCourse(c);
			c.getLessons().add(l2);

			courseRepository.save(c);
		};
	}
}
