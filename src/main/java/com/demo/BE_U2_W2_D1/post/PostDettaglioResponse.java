package com.demo.BE_U2_W2_D1.post;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDettaglioResponse {
    private Long id;
    private String titolo;
    private String testo;
    private String cover;
    private String categoria;
    private double tempoDiLettura;
    private Long autoreId;
    private Long postId;
}
