package com.bank.credit_card_service.usecase.domain;

import com.bank.credit_card_service.dataprovider.enums.StatusContaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ContaDomain {

    private Long id;
    private String agencia;
    private String conta;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    private StatusContaEnum status;
    private List<CartaoDomain> cartoes;
    private ClienteDomain cliente;

    public void habilitarConta() {
        this.status = StatusContaEnum.ATIVA;
    }
}
