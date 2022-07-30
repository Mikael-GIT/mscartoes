package io.github.mikaelgit.mscartoes.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.mikaelgit.mscartoes.domain.Cartao;
import io.github.mikaelgit.mscartoes.dtos.CartaoRequestDTO;
import io.github.mikaelgit.mscartoes.repositories.CartaoRepository;

@Service
public class CartaoService {
    
    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao save(CartaoRequestDTO request){
        return cartaoRepository.save(request.toModel());
    }

    public Optional<List<Cartao>> getCartoesRendaMenorOuIgual(Long renda) throws Exception{
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }



}