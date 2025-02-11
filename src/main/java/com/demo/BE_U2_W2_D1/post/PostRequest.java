package com.demo.BE_U2_W2_D1.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
  private String categoria;
  private String titolo;
  private String cover;
  private String contenuto;
  private double tempoDiLettura;
}