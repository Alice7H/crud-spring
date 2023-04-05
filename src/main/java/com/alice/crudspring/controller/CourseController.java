package com.alice.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alice.crudspring.controller.model.Course;
import com.alice.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

  private final CourseRepository courseRepository;

  // @RequestMapping(method = RequestMethod.GET)
  @GetMapping
  public List<Course> list() {
    return courseRepository.findAll();
  }

  @Bean
  CommandLineRunner initDatabase(CourseRepository courseRepository) {
    return args -> {
      courseRepository.deleteAll();

      Course c = new Course();
      c.setName("Angular with Spring");
      c.setCategory("front-end");

      courseRepository.save(c);
    };
  }
}
