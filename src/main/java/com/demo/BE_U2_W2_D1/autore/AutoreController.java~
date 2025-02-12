package com.demo.BE_U2_W2_D1.autore;


import com.demo.BE_U2_W2_D1.responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autore")
@RequiredArgsConstructor
public class AutoreController {
    private final AutoreService autoreService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Autore> findAll() {
        return autoreService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore findById(Long id) {
        return autoreService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody AutoreRequest request) {
        if(AutoreRepository.existsByEmail(request.getEmail())){throw new IllegalArgumentException("Email già presente");}
        if(AutoreRepository.existsByNome(request.getNome())){throw new IllegalArgumentException("Telefono già presente");}
        return autoreService.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreateResponse update(@PathVariable Long id, @RequestBody AutoreRequest request) {
        return autoreService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        autoreService.delete(id);
    }
}
