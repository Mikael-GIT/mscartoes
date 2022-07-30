package io.github.mikaelgit.mscartoes.controllers;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.mikaelgit.mscartoes.domain.Cartao;
import io.github.mikaelgit.mscartoes.dtos.CartaoRequestDTO;
import io.github.mikaelgit.mscartoes.services.CartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    
    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity createCard(@RequestBody CartaoRequestDTO request){
        Cartao cartao = request.toModel();
        cartaoService.save(request);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(cartao.getId())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity getClienteByCpf(@RequestParam("renda") Long renda) throws Exception {
        Optional<List<Cartao>> cartoes = cartaoService.getCartoesRendaMenorOuIgual(renda);
        if(cartoes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartoes);
    }


}