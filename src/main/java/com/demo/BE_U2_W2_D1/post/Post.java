package com.demo.BE_U2_W2_D1.post;

import com.demo.BE_U2_W2_D1.autore.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoDiLettura;


    @ManyToOne
    private Autore autore;
}