package com.alice.crudspring.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

// Abordagem antiga, versão anterior ao Java V14
// Record não disponível
@Data
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

}
