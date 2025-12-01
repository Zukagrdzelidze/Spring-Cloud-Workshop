package com.example.social_network.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
  private LocalDateTime timestamp;
  private String message;
  private String details;
}
