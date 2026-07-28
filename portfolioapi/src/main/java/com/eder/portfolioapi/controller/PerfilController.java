package com.eder.portfolioapi.controller;

import com.eder.portfolioapi.domain.Perfil;
import com.eder.portfolioapi.repository.PerfilRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "*") 
public class PerfilController {

    private final PerfilRepository repository;

    // CONSTRUTOR MANUAL: Injeção de dependência nativa que apaga o erro do Eclipse!
    public PerfilController(PerfilRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Perfil> obterPortfolioCompleto() {
        Perfil portfolio = repository.findCompleto().orElse(new Perfil());
        return ResponseEntity.ok(portfolio);
    }
}
