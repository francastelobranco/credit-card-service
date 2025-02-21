package com.bank.credit_card_service.entrypoint.dto.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContaDtoInput {

    @NotBlank(message = "A agência é obrigatória")
    @Pattern(regexp = "\\d{4}", message = "A agência deve conter exatamente 4 dígitos numéricos")
    private String agencia;

    @NotBlank(message = "A conta é obrigatória")
    @Pattern(regexp = "\\d{6}", message = "A conta deve conter exatamente 6 dígitos numéricos")
    private String conta;

    @Valid
    ClienteDtoIdInput cliente;
}
