package com.alice.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.alice.crudspring.dto.CourseDTO;
import com.alice.crudspring.enums.Category;
import com.alice.crudspring.model.Course;

@Component
public class CourseMapper {
  public CourseDTO toDTO(Course course) {
    if (course == null) {
      return null;
    }
    return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(),
        course.getLessons());
  }

  public Course toEntity(CourseDTO courseDTO) {
    if (courseDTO == null) {
      return null;
    }
    Course course = new Course();
    if (courseDTO.id() != null) {
      course.setId(courseDTO.id());
    }
    course.setName(courseDTO.name());
    course.setCategory(convertCagoryValue(courseDTO.category()));
    return course;
  }

  public Category convertCagoryValue(String value) {
    if (value == null) {
      return null;
    }
    return switch (value) {
      case "front-end" -> Category.FRONTEND;
      case "back-end" -> Category.BACKEND;
      default -> throw new IllegalArgumentException("Invalid value: " + value);
    };
  }
}
