package com.alice.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.alice.crudspring.enums.Category;
import com.alice.crudspring.model.Course;
import com.alice.crudspring.model.Lesson;
import com.alice.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			for (var i = 0; i < 10; i++) {
				Course c = new Course();
				c.setName("Angular with Spring " + (i + 1));
				c.setCategory(Category.FRONTEND);

				Lesson l = new Lesson();
				l.setName("Introdução");
				l.setYoutubeUrl("watch?v=123");
				l.setCourse(c);
				c.getLessons().add(l);

				Lesson l1 = new Lesson();
				l1.setName("Angular");
				l1.setYoutubeUrl("watch?v=321");
				l1.setCourse(c);
				c.getLessons().add(l1);

				courseRepository.save(c);
			}
		};
	}
}
