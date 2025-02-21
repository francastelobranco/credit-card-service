package com.bank.credit_card_service.dataprovider.mapper;

import com.bank.credit_card_service.dataprovider.entity.ContaEntity;
import com.bank.credit_card_service.usecase.domain.ContaDomain;

public class ContaMapper {

    public static ContaEntity converteParaEntidade(ContaDomain conta) {
        return ContaEntity.builder()
                .agencia(conta.getAgencia())
                .conta(conta.getConta())
                .status(conta.getStatus())
                .cartoes(conta.getCartoes() != null ? CartaoMapper.converteParaListaEntidade(conta.getCartoes()) : null)
                .cliente(conta.getCliente() != null ? ClienteMapper.converteParaEntidade(conta.getCliente()) : null)
                .build();
    }

    public static ContaDomain converteParaDomain(ContaEntity conta) {
        return ContaDomain.builder()
                .id(conta.getId())
                .agencia(conta.getAgencia())
                .conta(conta.getConta())
                .status(conta.getStatus())
                .dataCadastro(conta.getDataCadastro())
                .dataAlteracao(conta.getDataAlteracao())
                .status(conta.getStatus())
                .cliente(ClienteMapper.converteParaDomain(conta.getCliente()))
                .cartoes(conta.getCartoes() != null ? CartaoMapper.converteParaListaDomain(conta.getCartoes()): null)
                .build();
    }
}
