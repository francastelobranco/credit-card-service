package com.bank.credit_card_service.dataprovider.mapper;

import com.bank.credit_card_service.dataprovider.entity.CartaoEntity;
import com.bank.credit_card_service.dataprovider.enums.StatusCartaoEnum;
import com.bank.credit_card_service.dataprovider.enums.StatusEnvioEnum;
import com.bank.credit_card_service.dataprovider.enums.TipoCartao;
import com.bank.credit_card_service.entrypoint.dto.output.CartaoDtoOutput;
import com.bank.credit_card_service.usecase.domain.CartaoDomain;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;


@Builder
public class CartaoMapper {

    public static CartaoEntity converteParaEntidade(CartaoDomain cartao) {
        return CartaoEntity.builder()
                .id(cartao.getId() != null ? cartao.getContaId() : null)
                .contaId(cartao.getContaId())
                .numero(cartao.getNumero())
                .nomeTitular(cartao.getNomeTitular())
                .dataCadastro(cartao.getDataCadastro())
                .dataAlteracao(cartao.getDataAlteracao())
                .dataValidade(cartao.getDataValidade())
                .bandeira(cartao.getBandeira())
                .statusCartao(StatusCartaoEnum.valueOf(cartao.getStatusCartao()))
                .statusEnvio(StatusEnvioEnum.valueOf(cartao.getStatusEnvio()))
                .tipoCartao(cartao.getTipoCartao() != null ? TipoCartao.valueOf(cartao.getTipoCartao()) : null)
                .build();
    }

    public static CartaoDomain converteParaDomain(CartaoEntity cartao) {
        return CartaoDomain.builder()
                .id(cartao.getId())
                .contaId(cartao.getContaId())
                .numero(cartao.getNumero())
                .nomeTitular(cartao.getNomeTitular())
                .dataValidade(cartao.getDataValidade())
                .dataCadastro(cartao.getDataCadastro())
                .dataAlteracao(cartao.getDataAlteracao())
                .bandeira(cartao.getBandeira())
                .statusCartao(cartao.getStatusCartao().toString())
                .statusEnvio(cartao.getStatusEnvio() != null ? cartao.getStatusEnvio().toString(): null)
                .tipoCartao(cartao.getTipoCartao().toString())
                .build();
    }

    public static CartaoDtoOutput converteParaDtoOutput(CartaoDomain cartao) {
        return CartaoDtoOutput.builder()
                .id(cartao.getId())
                .numero(cartao.getNumero())
                .nomeTitular(cartao.getNomeTitular())
                .dataValidade(cartao.getDataValidade())
                .dataCadastro(cartao.getDataCadastro())
                .dataAlteracao(cartao.getDataAlteracao())
                .bandeira(cartao.getBandeira().toString())
                .statusCartao(cartao.getStatusCartao())
                .statusEnvio(cartao.getStatusEnvio())
                .build();
    }

    public static List<CartaoDomain> converteParaListaDomain(List<CartaoEntity> cartoes) {
        return cartoes.stream().map(cartao -> converteParaDomain(cartao)).collect(Collectors.toList());
    }

    public static List<CartaoEntity> converteParaListaEntidade(List<CartaoDomain> cartoes) {
        return cartoes.stream().map(cartao -> converteParaEntidade(cartao)).collect(Collectors.toList());
    }

}
