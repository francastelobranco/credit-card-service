package com.bank.credit_card_service.usecase.exceptions;

public class NegocioException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NegocioException(String mensagem){
        super(mensagem);
    }
}
