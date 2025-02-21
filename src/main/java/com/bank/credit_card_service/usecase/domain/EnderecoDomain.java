package com.bank.credit_card_service.usecase.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class EnderecoDomain {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
}
