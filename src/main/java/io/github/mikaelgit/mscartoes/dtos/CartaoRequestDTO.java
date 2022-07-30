package io.github.mikaelgit.mscartoes.dtos;

import java.math.BigDecimal;

import io.github.mikaelgit.mscartoes.domain.Cartao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartaoRequestDTO {

    private String nome;

    private String bandeira;

    private BigDecimal renda;

    private BigDecimal limiteBasico;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limiteBasico);
    }
}