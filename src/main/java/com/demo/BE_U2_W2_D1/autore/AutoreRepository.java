package com.demo.BE_U2_W2_D1.autore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<Autore, Long> {
    public static boolean existsByEmail(String email) {
        return false;
    }

    static boolean existsByNome(String nome) {
        return false;
    }
}
