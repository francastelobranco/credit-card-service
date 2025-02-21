package com.bank.credit_card_service.dataprovider.mapper;

import com.bank.credit_card_service.dataprovider.entity.ClienteEntity;
import com.bank.credit_card_service.usecase.domain.ClienteDomain;

public class ClienteMapper {

    public static ClienteEntity converteParaEntidade(ClienteDomain cliente) {
        return ClienteEntity.builder()
                .nomeCliente(cliente.getNomeCliente())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .endereco(cliente.getEndereco() != null ? EnderecoMapper.converteParaEntidade(cliente.getEndereco()) : null)
                .build();
    }

    public static ClienteDomain converteParaDomain(ClienteEntity cliente) {
        return ClienteDomain.builder()
                .id(cliente.getId())
                .nomeCliente(cliente.getNomeCliente())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .dataCadastro(cliente.getDataCadastro())
                .dataAlteracao(cliente.getDataAlteracao())
                .endereco(EnderecoMapper.converteParaDomain(cliente.getEndereco()))
                .build();
    }
}
