package com.bank.credit_card_service.entrypoint.mapper;

import com.bank.credit_card_service.usecase.domain.ClienteDomain;
import com.bank.credit_card_service.entrypoint.dto.input.ClienteDtoInput;
import com.bank.credit_card_service.entrypoint.dto.output.ClienteDtoOutput;

public class ClienteDtoMapper {

    public static ClienteDomain converteParaDomain(ClienteDtoInput cliente) {
        return ClienteDomain.builder()
                .nomeCliente(cliente.getNomeCliente())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .endereco(EnderecoDtoMapper.converteParaDomain(cliente.getEndereco()))
                .build();
    }

    public static ClienteDtoOutput converteParaOutput(ClienteDomain cliente) {
        return ClienteDtoOutput.builder()
                .id(cliente.getId())
                .nomeCliente(cliente.getNomeCliente())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .dataCadastro(cliente.getDataCadastro())
                .dataAlteracao(cliente.getDataAlteracao())
                .endereco(EnderecoDtoMapper.converteParaDomain(cliente.getEndereco()))
                .build();
    }

    public static ClienteDomain converteIdCliente(Long id) {
        return ClienteDomain.builder()
                .id(id)
                .build();
    }
}
