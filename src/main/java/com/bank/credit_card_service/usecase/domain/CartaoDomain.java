package com.bank.credit_card_service.usecase.domain;

import com.bank.credit_card_service.dataprovider.enums.BandeiraEnum;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartaoDomain {
    private Long id;
    private String numero;
    private String nomeTitular;
    private LocalDate dataValidade;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;
    private BandeiraEnum bandeira;
    private String statusCartao;
    private String statusEnvio;
    private String tipoCartao;
    private Long contaId;

    public void ativar(){
        this.statusCartao = "ATIVO";
    }

    public void inativar(){
        this.statusCartao = "INATIVO";
    }

    public void enviar(){
        this.statusEnvio = "ENVIADO";
    }

    public void receber(){
        this.statusEnvio = "RECEBIDO";
    }

    public void pendente(){
        this.statusEnvio = "PENDENTE";
    }
}
