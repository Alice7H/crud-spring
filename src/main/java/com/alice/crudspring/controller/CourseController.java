package com.alice.crudspring.controller;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alice.crudspring.model.Course;
import com.alice.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

  private final CourseRepository courseRepository;

  // @RequestMapping(method = RequestMethod.GET)
  @GetMapping
  public @ResponseBody List<Course> list() {
    return courseRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Course create(@RequestBody Course course) {
    // System.out.println(course.getName());
    // return
    // ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    return courseRepository.save(course);
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
