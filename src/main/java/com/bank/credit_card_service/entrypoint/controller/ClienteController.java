package com.bank.credit_card_service.entrypoint.controller;

import com.bank.credit_card_service.entrypoint.dto.input.ClienteDtoInput;
import com.bank.credit_card_service.entrypoint.dto.output.ClienteDtoOutput;
import com.bank.credit_card_service.entrypoint.mapper.ClienteDtoMapper;
import com.bank.credit_card_service.usecase.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDtoOutput> cadastrarCliente(@RequestBody @Valid ClienteDtoInput input) {
        var cliente = service.cadastrarCliente(ClienteDtoMapper.converteParaDomain(input));
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteDtoMapper.converteParaOutput(cliente));
    }
}
