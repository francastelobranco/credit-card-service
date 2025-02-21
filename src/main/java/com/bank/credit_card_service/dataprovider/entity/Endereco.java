package com.bank.credit_card_service.dataprovider.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Endereco {

    @Column(name = "cliente_cep")
    private String cep;

    @Column(name = "cliente_logradouro")
    private String logradouro;

    @Column(name = "cliente_numero")
    private String numero;

    @Column(name = "cliente_complemento")
    private String complemento;

    @Column(name = "cliente_bairro")
    private String bairro;
}
