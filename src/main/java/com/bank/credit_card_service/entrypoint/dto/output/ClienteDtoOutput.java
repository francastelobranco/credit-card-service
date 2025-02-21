package com.bank.credit_card_service.entrypoint.dto.output;

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
public class ClienteDtoOutput {

    private Long id;
    private String nomeCliente;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    private EnderecoDtoOutput endereco;
}
