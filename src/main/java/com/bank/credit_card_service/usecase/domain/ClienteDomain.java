package com.bank.credit_card_service.usecase.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ClienteDomain {

    private Long id;
    private String nomeCliente;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    private EnderecoDomain endereco;
    private ContaDomain conta;
}
