package com.alice.crudspring.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// Abordagem antiga, versão anterior ao Java V14
// Record não disponível
public class CourseDTOLegacy {
  private Long _id;

  @NotBlank
  @NotNull
  @Length(min = 5, max = 100)
  private String name;

  @NotNull
  @Length(max = 10)
  @Pattern(regexp = "back-end|front-end")
  private String category;

  public Long get_id() {
    return _id;
  }

  public void set_id(Long _id) {
    this._id = _id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
