package com.demo.BE_U2_W2_D1.autore;


import com.demo.BE_U2_W2_D1.responses.CreateResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoreService {
      private final AutoreRepository autoreRepository;

      public List<Autore> findAll() {
          return autoreRepository.findAll();
      }

    public Autore findById(Long id) {
       if(!autoreRepository.existsById(id)){
           throw new EntityNotFoundException("Autore non trovato");
       }
       return autoreRepository.findById(id).get();
}
    public CreateResponse save( AutoreRequest request) {
          Autore autore = new Autore();
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);
        return new CreateResponse(autore.getId());
    }

    public CreateResponse update(Long id, AutoreRequest request) {
        Autore autore = findById(id);
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);
        return new CreateResponse(autore.getId());
    }

    public void delete(Long id) {
        Autore autore = findById(id);
        autoreRepository.delete(autore);
    }
}
