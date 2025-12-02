package com.example.social_network.users;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  private Integer id;

  @Size(min = 2, message = "Name should have at least 2 characters")
  private String name;

  @Past(message = "Birth date should be in past")
  private LocalDate birthDate;
}
