package com.bank.credit_card_service.entrypoint.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContaDtoOutput {

    private Long id;
    private String agencia;

    private String conta;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    private String status;
    private List<CartaoDtoOutput> cartao;
    private ClienteDtoOutput cliente;
}
