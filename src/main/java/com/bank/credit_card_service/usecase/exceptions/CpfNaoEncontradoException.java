package com.bank.credit_card_service.usecase.exceptions;

public class CpfNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;


    public CpfNaoEncontradoException(String cpf) {
        super(String.format("CPF de número %s não foi encontrada", cpf));
    }
}
