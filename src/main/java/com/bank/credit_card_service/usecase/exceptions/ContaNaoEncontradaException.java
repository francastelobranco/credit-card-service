package com.bank.credit_card_service.usecase.exceptions;

public class ContaNaoEncontradaException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;


    public ContaNaoEncontradaException(Long id) {
        super(String.format("A conta %d não foi encontrada", id));
    }
}
