package com.eder.portfolioapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_certificados")
public class Certificado {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome; 
    private String emissor; 
    private String ano; 
    private String url;

    // Getters e Setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getEmissor() { return emissor; } public void setEmissor(String emissor) { this.emissor = emissor; }
    public String getAno() { return ano; } public void setAno(String ano) { this.ano = ano; }
    public String getUrl() { return url; } public void setUrl(String url) { this.url = url; }
}
