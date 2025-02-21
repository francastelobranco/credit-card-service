package com.bank.credit_card_service.entrypoint.mapper;

import com.bank.credit_card_service.entrypoint.dto.input.EnderecoDtoInput;
import com.bank.credit_card_service.entrypoint.dto.output.EnderecoDtoOutput;
import com.bank.credit_card_service.usecase.domain.EnderecoDomain;

public class EnderecoDtoMapper {


    public static EnderecoDtoOutput converteParaDomain(EnderecoDomain endereco) {
        return EnderecoDtoOutput.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .build();
    }

    public static EnderecoDomain converteParaDomain(EnderecoDtoInput endereco) {
        return EnderecoDomain.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .build();
    }
}
