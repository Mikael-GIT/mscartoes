package io.github.mikaelgit.mscartoes.dtos;

import java.math.BigDecimal;

import io.github.mikaelgit.mscartoes.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartoesPorClienteDTO {
    
    private String nome;

    private String bandeira;

    private BigDecimal limiteLiberado;

    public static CartoesPorClienteDTO fromModel(ClienteCartao model){
        return new CartoesPorClienteDTO(
            model.getCartao().getNome(),
            model.getCartao().getBandeira(),
            model.getLimite()
        );
    }
}