package com.bank.credit_card_service.entrypoint.mapper;

import com.bank.credit_card_service.dataprovider.enums.BandeiraEnum;
import com.bank.credit_card_service.usecase.domain.CartaoDomain;
import com.bank.credit_card_service.entrypoint.dto.input.CartaoDtoInput;
import com.bank.credit_card_service.entrypoint.dto.output.CartaoDtoOutput;

import java.util.List;
import java.util.stream.Collectors;


public class CartaoDtoMapper {

    public static CartaoDomain converteParaDomain(CartaoDtoInput cartao) {
        return CartaoDomain.builder()
                .numero(cartao.getNumero())
                .bandeira(BandeiraEnum.valueOf(cartao.getBandeira()))
                .build();
    }

    public static CartaoDtoOutput converteParaOutput(CartaoDomain cartao) {
        return CartaoDtoOutput.builder()
                .id(cartao.getId())
                .numero(cartao.getNumero())
                .nomeTitular(cartao.getNomeTitular())
                .dataValidade(cartao.getDataValidade())
                .dataCadastro(cartao.getDataCadastro())
                .dataAlteracao(cartao.getDataAlteracao())
                .bandeira(String.valueOf(cartao.getBandeira()))
                .statusCartao(cartao.getStatusCartao())
                .statusEnvio(cartao.getStatusEnvio() != null ? cartao.getStatusEnvio() : null)
                .tipoCartao(cartao.getTipoCartao())
                .build();
    }

    public static List<CartaoDtoOutput> converteParaListaOutput(List<CartaoDomain> cartoes) {
        return cartoes.stream()
                .map(cartaoDomain -> converteParaOutput(cartaoDomain))
                .collect(Collectors.toList());
    }
}
