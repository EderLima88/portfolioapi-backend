package com.eder.portfolioapi.repository;

import com.eder.portfolioapi.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    // Busca nativa simplificada que elimina o conflito do Hibernate
}
