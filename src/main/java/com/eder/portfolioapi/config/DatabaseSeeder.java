package com.eder.portfolioapi.config;

import com.eder.portfolioapi.domain.*;
import com.eder.portfolioapi.repository.PerfilRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList; 
import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    private final PerfilRepository repository;

    public DatabaseSeeder(PerfilRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional //GARANTE QUE O SPRING SÓ ABRA A API APÓS O COMMIT TOTAL NO BANCO
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            Perfil eder = new Perfil();
            eder.setNome("Eder de Lima");
            eder.setCargo("Desenvolvedor Full Stack Júnior | Java | Spring Boot | APIs REST | Angular | React | Docker | Linux & Shell Scripting");
            eder.setFormacao("Graduação em Tecnologia");
            eder.setResumo("No desenvolvimento backend, possuo base na criação de APIs RESTful, padronizadas e escaláveis utilizando Java, Spring Boot e persistência de dados em MySQL. No frontend, possuo flexibilidade desenvolvimento em interfaces dinâmicas tanto com Angular quanto com React consumindo serviços REST. Possuo facilidade em ambientes Linux, atuando com automação em Shell Scripting e containerização de aplicações utilizando Docker. Busco minha primeira oportunidade para aplicar boas práticas de desenvolvimento (Clean Code), arquitetura de software e cultura DevOps.");
            eder.setLinkGithub("https://github.com/EderLima88"); 
            eder.setLinkLinkedin("https://www.linkedin.com/in/%C3%A9der-de-lima-64b70626a/");
            eder.setEmail("eder.ebl@gmail.com"); 
            eder.setTelefone("https://wa.me/5551984049178");
            eder.setCompetencias(List.of("APIs RESTful", "Spring Boot", "Docker", "React", "Angular", "Java", "MySQL", "Shell Scripting", "Linux"));

            List<Projeto> projs = new ArrayList<>();
            Projeto p1 = new Projeto(); p1.setTitulo("Projeto CRUD em Java para aplicação Desktop"); p1.setDescricao("Aplicação desktop desenvolvida em Java com interface gráfica, permitindo a manipulação de dados em um banco de dados SQLite."); p1.setLinkGithub("https://github.com/EderLima88/JavaCrudSqlite"); p1.setTags(List.of("Java", "Swing", "MySQL")); projs.add(p1);
            Projeto p2 = new Projeto(); p2.setTitulo("Infraestrutura como Código (IaC) - Linux"); p2.setDescricao("Projeto de infra como código (IaC) para configuração de serviços e gerenciamento de usuários."); p2.setLinkGithub("https://github.com/EderLima88/linux-proj1-infra"); p2.setTags(List.of("Linux", "Shell Scripting", "Automação")); projs.add(p2);
            Projeto p3 = new Projeto(); p3.setTitulo("API RESTful - Sistema de E-commerce"); p3.setDescricao("API completa para gerenciamento de produtos, carrinho de compras e pedidos dos usuários."); p3.setLinkGithub("https://github.com/EderLima88/react-docker-yarn-typescript-2"); p3.setTags(List.of("Docker", "TypeScript", "React")); projs.add(p3);
            Projeto p4 = new Projeto(); p4.setTitulo("Aplicação Spring Boot com H2 Database"); p4.setDescricao("Aplicação desenvolvida com Spring Boot com padrão MVC"); p4.setLinkGithub("https://github.com/EderLima88/spring-rest-api-h2"); p4.setTags(List.of("Java", "Spring Boot", "MVC", "H2 Database")); projs.add(p4);
            Projeto p5 = new Projeto(); p5.setTitulo("Aplicação gestão de pessoas com HTML, CSS e JavaScript puros"); p5.setDescricao("Manipuação de dados de pessoas com HTML, CSS e JavaScript puros, utilizando LocalStorage MYSQL."); p5.setLinkGithub("https://github.com/EderLima88/CRUDTargetTrust"); p5.setTags(List.of("HTML", "Bootstrap", "PHP", "MySQL")); projs.add(p5);
            Projeto p6 = new Projeto(); p6.setTitulo("Blog em Angula no git pages sobre Silent Hill"); p6.setDescricao("Blog desenvolvido em Angular, hospedado no GitHub Pages, abordando informações e curiosidades sobre a franquia de jogos Silent Hill."); p6.setLinkGithub("https://github.com/EderLima88/angular-blog-jogos"); p6.setTags(List.of("Angular", "GitHub Pages", "Modular", "Routing")); projs.add(p6);
            eder.setProjetos(projs);

            List<Certificado> certs = new ArrayList<>();
            Certificado c1 = new Certificado(); c1.setNome("Analise e Desenvolvimento de Software"); c1.setEmissor("Uniasselvi"); c1.setAno("2020"); c1.setUrl("https://drive.google.com/file/d/1OFpS1AfGCbUv-pxGv-ciQJ1VxUeOC791/view?usp=drive_link"); certs.add(c1);
            Certificado c2 = new Certificado(); c2.setNome("Engenharia de Software"); c2.setEmissor("Uniasselvi"); c2.setAno("2025"); c2.setUrl("https://drive.google.com/file/d/1xIHT-ErZVpSb0oRyTTzQEQz5QyzwZvN3/view?usp=drive_link"); certs.add(c2);
            Certificado c3 = new Certificado(); c3.setNome("Desenvolvimento de Sistemas com JAVA"); c3.setEmissor("Uniasselvi"); c3.setAno("2024"); c3.setUrl("https://drive.google.com/file/d/1lUr4IbfAqTxxu25YeIaybAiR3Q6-vuF8/view?usp=drive_link"); certs.add(c3);
            Certificado c4 = new Certificado(); c4.setNome("Ciência de DadosCiência de Dados"); c4.setEmissor("Uniasselvi"); c4.setAno("2023"); c4.setUrl("https://drive.google.com/file/d/1sU3N4wjVvk8xln7mKe3nCufoOhw-SgFT/view?usp=drive_link"); certs.add(c4);
            eder.setCertificados(certs);

            repository.saveAndFlush(eder);
            System.out.println("🚀 Banco de dados PostgreSQL populado com sucesso com os dados do Eder!");
        }
    }
}
//atualizado 29 jun 2026.
