package io.github.mikaelgit.mscartoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.mikaelgit.mscartoes.domain.Cartao;
import io.github.mikaelgit.mscartoes.domain.ClienteCartao;
import io.github.mikaelgit.mscartoes.repositories.ClienteCartaoRepository;

@Service
public class ClienteCartaoService {
    
    @Autowired
    private ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return clienteCartaoRepository.findByCpf(cpf);
    }
}