package com.bank.credit_card_service.entrypoint.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoDtoOutput {
    private Long id;
    private String numero;
    private String nomeTitular;
    private LocalDate dataValidade;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    private String bandeira;
    private String statusCartao;
    private String statusEnvio;
    private String tipoCartao;
}
