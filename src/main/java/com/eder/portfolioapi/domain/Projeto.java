package com.eder.portfolioapi.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_projetos")
public class Projeto {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo; 
    private String descricao; 
    private String linkGithub;
    
    @ElementCollection 
    @CollectionTable(name = "tb_projeto_tags", joinColumns = @JoinColumn(name = "projeto_id"))
    @Column(name = "tag")
    private List<String> tags;

    // Getters e Setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; } public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; } public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getLinkGithub() { return linkGithub; } public void setLinkGithub(String linkGithub) { this.linkGithub = linkGithub; }
    public List<String> getTags() { return tags; } public void setTags(List<String> tags) { this.tags = tags; }
}
