package com.demo.BE_U2_W2_D1.autore;

import com.demo.BE_U2_W2_D1.email.EmailService;
import com.demo.BE_U2_W2_D1.responses.CreateResponse;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Validated
public class AutoreService {

    private static final Logger LOGGER = Logger.getLogger(AutoreService.class.getName());

    private final AutoreRepository autoreRepository;
    private final EmailService emailService;

    @Value("${messages.new.autore.subject:Benvenuto nel sistema}")
    private String subject;

    @Value("${messages.new.autore.body:Grazie per esserti registrato, la tua email è}")
    private String body;

    public Page<Autore> findAll(Pageable pageable) {
        return autoreRepository.findAll(pageable);
    }

    public Autore findById(Long id) {
        return autoreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autore non trovato con ID: " + id));
    }

    @Transactional
    public CreateResponse save(@Valid AutoreRequest request) {
        Autore autore = new Autore();
        autore.setNome(request.getNome());
        autore.setCognome(request.getCognome());
        autore.setEmail(request.getEmail());

        autore = autoreRepository.save(autore);

        try {
            emailService.sendEmail(autore.getEmail(), subject, body + " " + autore.getEmail());
        } catch (MessagingException e) {
            LOGGER.warning("Errore nell'invio dell'email a " + autore.getEmail() + ": " + e.getMessage());
        }

        return new CreateResponse(autore.getId());
    }

    @Transactional
    public CreateResponse update(Long id, AutoreRequest request) {
        Autore autore = findById(id);
        BeanUtils.copyProperties(request, autore, "id"); // Evita di sovrascrivere l'ID
        autoreRepository.save(autore);
        return new CreateResponse(autore.getId());
    }

    @Transactional
    public void delete(Long id) {
        Autore autore = findById(id);
        autoreRepository.delete(autore);
    }
}

