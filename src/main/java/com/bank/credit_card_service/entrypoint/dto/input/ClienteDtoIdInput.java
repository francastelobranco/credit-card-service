package com.bank.credit_card_service.entrypoint.dto.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ClienteDtoIdInput {

    @NotNull
    private Long id;
}
