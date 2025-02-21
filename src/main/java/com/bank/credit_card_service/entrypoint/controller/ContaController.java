package com.bank.credit_card_service.entrypoint.controller;

import com.bank.credit_card_service.entrypoint.dto.input.ContaDtoInput;
import com.bank.credit_card_service.entrypoint.dto.output.ContaDtoOutput;
import com.bank.credit_card_service.entrypoint.mapper.ContaDtoMapper;
import com.bank.credit_card_service.usecase.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService service;

    @PostMapping
    public ResponseEntity<ContaDtoOutput> criarConta(@RequestBody @Valid ContaDtoInput input) {
        var inputDomain = service.criar(ContaDtoMapper.converteParaDomain(input));
        var output = ContaDtoMapper.converteParaOutput(inputDomain);
       return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @GetMapping("buscarPorId/{id}")
    public ResponseEntity<ContaDtoOutput> buscarConta(@PathVariable Long id) {
        var inputDomain = service.buscarConta(id);
        var output = ContaDtoMapper.converteParaOutput(inputDomain);
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @GetMapping("buscaPorCpf/{cpf}")
    public ResponseEntity<ContaDtoOutput> buscarPorCpf(@PathVariable String cpf) {
        var inputDomain = service.buscarPorCpf(cpf);
        var output = ContaDtoMapper.converteParaOutput(inputDomain);
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @PutMapping("inativarPorId/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativarContaPorId(@PathVariable Long id) {
        service.inativatConta(id);
    }
}
