package com.example.lab2.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

  private Long id;
  private Long userId;
  private Long categoryId;
  private LocalDateTime createdAt;
  private Double amount;
}
