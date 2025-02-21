package com.bank.credit_card_service.entrypoint.mapper;

import com.bank.credit_card_service.dataprovider.mapper.CartaoMapper;
import com.bank.credit_card_service.entrypoint.dto.input.ContaDtoInput;
import com.bank.credit_card_service.entrypoint.dto.output.ContaDtoOutput;
import com.bank.credit_card_service.usecase.domain.ContaDomain;

import java.util.Collections;

public class ContaDtoMapper {

    public static ContaDomain converteParaDomain(ContaDtoInput conta) {
        return ContaDomain.builder()
                .agencia(conta.getAgencia())
                .conta(conta.getConta())
                .cliente(ClienteDtoMapper.converteIdCliente(conta.getCliente().getId()))
                .build();
    }

    public static ContaDomain converteParaDomain(Long id) {
        return ContaDomain.builder()
                .id(id)
                .build();
    }

    public static ContaDtoOutput converteParaOutput(ContaDomain conta) {
        return ContaDtoOutput.builder()
                .id(conta.getId())
                .conta(conta.getConta())
                .agencia(conta.getAgencia())
                .cartao(conta.getCartoes() != null ? CartaoDtoMapper.converteParaListaOutput(conta.getCartoes()) : Collections.emptyList())
                .status(String.valueOf(conta.getStatus()))
                .dataCadastro(conta.getDataCadastro())
                .dataAlteracao(conta.getDataAlteracao())
                .cliente(ClienteDtoMapper.converteParaOutput(conta.getCliente()))
                .build();
    }
}
