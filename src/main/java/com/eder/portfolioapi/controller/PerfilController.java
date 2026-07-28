package com.eder.portfolioapi.controller;

import com.eder.portfolioapi.domain.Perfil;
import com.eder.portfolioapi.repository.PerfilRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "*") 
public class PerfilController {

    private final PerfilRepository repository;

    public PerfilController(PerfilRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obterPortfolioCompleto() {
        // Busca o perfil ou joga um objeto vazio
        Perfil perfil = repository.findAll().stream().findFirst().orElse(new Perfil());
        
        // Monta um mapa chave-valor para garantir que o Jackson serialize sem travar nas coleções do JPA
        Map<String, Object> jsonSeguro = new HashMap<>();
        jsonSeguro.put("id", perfil.getId());
        jsonSeguro.put("nome", perfil.getNome());
        jsonSeguro.put("cargo", perfil.getCargo());
        jsonSeguro.put("formacao", perfil.getFormacao());
        jsonSeguro.put("resumo", perfil.getResumo());
        jsonSeguro.put("linkGithub", perfil.getLinkGithub());
        jsonSeguro.put("linkLinkedin", perfil.getLinkLinkedin());
        jsonSeguro.put("email", perfil.getEmail());
        jsonSeguro.put("telefone", perfil.getTelefone());
        
        // Garante que as listas sejam entregues limpas para o Angular
        jsonSeguro.put("competencias", perfil.getCompetencias());
        jsonSeguro.put("projetos", perfil.getProjetos());
        jsonSeguro.put("certificados", perfil.getCertificados());
        
        return ResponseEntity.ok(jsonSeguro);
    }
}
