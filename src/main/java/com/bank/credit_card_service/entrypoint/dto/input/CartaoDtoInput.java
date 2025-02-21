package com.bank.credit_card_service.entrypoint.dto.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartaoDtoInput {

    @NotBlank(message = "O número do cartão é obrigatório")
    @Pattern(regexp = "\\d{16}", message = "O número do cartão deve conter exatamente 16 dígitos numéricos, sem espaços ou hífens")
    private String numero;

    @NotBlank(message = "A bandeira do cartão é obrigatória")
    private String bandeira;

    @Valid
    private ContaDtoIdInput conta;
}
