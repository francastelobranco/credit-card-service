package com.bank.credit_card_service.dataprovider.mapper;

import com.bank.credit_card_service.dataprovider.entity.Endereco;
import com.bank.credit_card_service.usecase.domain.EnderecoDomain;

public class EnderecoMapper {

    public static Endereco converteParaEntidade(EnderecoDomain endereco) {
        return Endereco.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .build();
    }

    public static EnderecoDomain converteParaDomain(Endereco endereco) {
        return EnderecoDomain.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .build();
    }
}
