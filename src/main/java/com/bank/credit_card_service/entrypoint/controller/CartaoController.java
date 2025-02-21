package com.bank.credit_card_service.entrypoint.controller;

import com.bank.credit_card_service.entrypoint.dto.input.CartaoDtoInput;
import com.bank.credit_card_service.entrypoint.dto.output.CartaoDtoOutput;
import com.bank.credit_card_service.entrypoint.mapper.CartaoDtoMapper;
import com.bank.credit_card_service.usecase.service.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    CartaoService service;

    @PostMapping("/cadastrarCartao")
    public ResponseEntity<CartaoDtoOutput> cadastrarCartao(@RequestBody @Valid CartaoDtoInput input) {
        var cartao = service.cadastrarCartaoFisico(CartaoDtoMapper.converteParaDomain(input), input.getConta().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(CartaoDtoMapper.converteParaOutput(cartao));
    }

    @GetMapping("/cadastrarCartao/virtual/{idConta}")
    public ResponseEntity<CartaoDtoOutput> cadastrarCartaoVirtual(@PathVariable Long idConta) {
        var cartao = service.cadastrarCartaoVirtual(idConta);
        return ResponseEntity.status(HttpStatus.CREATED).body(CartaoDtoMapper.converteParaOutput(cartao));
    }

    @PutMapping("ativarPorId/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ativarCartao(@PathVariable Long id) {
        service.ativarCartao(id);
    }

    @PutMapping("enviarCartaoFisico/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void enviarCartaoFisico(@PathVariable Long id) {
        service.enviarCartaoFisico(id);
    }

    @PutMapping("confirmarRecebimentoCartaoFisico/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmarRecebimento(@PathVariable Long id) {
        service.confirmarRecebimento(id);
    }
}
