package com.demo.BE_U2_W2_D1.autore;


import com.demo.BE_U2_W2_D1.post.Post;
import com.demo.BE_U2_W2_D1.post.PostDettaglioResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreDettaglioResponse {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
    private Set<Post> posts;
}
