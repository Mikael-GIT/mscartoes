package io.github.mikaelgit.mscartoes.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.github.mikaelgit.mscartoes.domain.Cartao;

@EnableJpaRepositories
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Optional<List<Cartao>> findByRendaLessThanEqual(BigDecimal rendaBigDecimal);
    
}