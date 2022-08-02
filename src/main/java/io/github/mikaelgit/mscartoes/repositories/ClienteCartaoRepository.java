package io.github.mikaelgit.mscartoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.github.mikaelgit.mscartoes.domain.ClienteCartao;

@EnableJpaRepositories
public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {

    List<ClienteCartao> findByCpf(String cpf);
    
}