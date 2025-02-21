package com.bank.credit_card_service.entrypoint.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    RECURSO_NAO_ENCONTRADO("/entidade-nao_encontrada", "Entidade não encontrada"),
    ERRO_NEGOCIO("/erro-negocio", "Violação da regra de negócio"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema");

    private String title;
    private String uri;

    ProblemType(String path, String title){
        this.uri = "http://creditcard.com.br" + path;
        this.title  = title;
    }
}
