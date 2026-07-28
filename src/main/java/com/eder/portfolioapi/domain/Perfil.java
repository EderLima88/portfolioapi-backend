package com.eder.portfolioapi.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_perfil")
public class Perfil {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome; 
    private String cargo; 
    private String formacao;
    
    @Column(columnDefinition = "TEXT") 
    private String resumo;
    
    private String linkGithub; 
    private String linkLinkedin; 
    private String email; 
    private String telefone;
    
    @ElementCollection 
    @CollectionTable(name = "tb_perfil_competencias", joinColumns = @JoinColumn(name = "perfil_id"))
    @Column(name = "competencia")
    private List<String> competencias;
    
    // CORRIGIDO: Voltamos para LAZY para evitar o conflito do Hibernate 6
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id")
    private List<Projeto> projetos; 

    // CORRIGIDO: Voltamos para LAZY
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id")
    private List<Certificado> certificados;


    // Getters e Setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getCargo() { return cargo; } public void setCargo(String cargo) { this.cargo = cargo; }
    public String getFormacao() { return formacao; } public void setFormacao(String formacao) { this.formacao = formacao; }
    public String getResumo() { return resumo; } public void setResumo(String resumo) { this.resumo = resumo; }
    public String getLinkGithub() { return linkGithub; } public void setLinkGithub(String linkGithub) { this.linkGithub = linkGithub; }
    public String getLinkLinkedin() { return linkLinkedin; } public void setLinkLinkedin(String linkLinkedin) { this.linkLinkedin = linkLinkedin; }
    public String getEmail() { return email; } public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; } public void setTelefone(String telefone) { this.telefone = telefone; }
    public List<String> getCompetencias() { return competencias; } public void setCompetencias(List<String> competencias) { this.competencias = competencias; }
    public List<Projeto> getProjetos() { return projetos; } public void setProjetos(List<Projeto> projetos) { this.projetos = projetos; }
    public List<Certificado> getCertificados() { return certificados; } public void setCertificados(List<Certificado> certificados) { this.certificados = certificados; }
}
