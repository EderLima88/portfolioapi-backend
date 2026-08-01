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
    public ResponseEntity<?> obterPortfolioCompleto() {
        // 📡 Busca a primeira linha da tabela no PostgreSQL
        Perfil perfil = repository.findAll().stream().findFirst().orElse(new Perfil());
        
        // 🚨 VALIDAÇÃO DE SEGURANÇA (ANTI-COLD-START):
        // Se o perfil não existir no banco OU se o nome/resumo vier nulo por lentidão do primeiro boot
        if (perfil.getId() == null || perfil.getNome() == null || perfil.getResumo() == null) {
            
            // Pausa defensiva de hardware de 800ms para aguardar o DatabaseSeeder fechar a transação
            try { 
                Thread.sleep(800); 
            } catch (InterruptedException e) { 
                Thread.currentThread().interrupt(); 
            }
            
            // Refaz a consulta ao banco de dados com a carga de dados já consolidada
            perfil = repository.findAll().stream().findFirst().orElse(new Perfil());
            
            // Se mesmo após a pausa o banco continuar vazio, retorna um status limpo avisando o cliente
            if (perfil.getNome() == null) {
                return ResponseEntity.status(503).body("O servidor ainda está inicializando o banco de dados. Aguarde.");
            }
        }
        
        // 🔒 Monta um mapa chave-valor para garantir que o Jackson serialize sem travar nas coleções do JPA
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
