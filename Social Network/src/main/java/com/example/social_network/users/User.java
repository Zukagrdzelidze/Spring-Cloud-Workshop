package com.example.social_network.users;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private LocalDate birthDate;
}
