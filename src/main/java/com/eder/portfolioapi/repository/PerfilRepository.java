package com.eder.portfolioapi.repository;

import com.eder.portfolioapi.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
    @Query("SELECT DISTINCT p FROM Perfil p LEFT JOIN FETCH p.projetos LEFT JOIN FETCH p.certificados")
    Optional<Perfil> findCompleto();
}
