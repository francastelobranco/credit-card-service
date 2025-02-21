package com.bank.credit_card_service.usecase.exceptions;

public class CartaoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;


    public CartaoNaoEncontradoException(Long id) {
        super(String.format("O cartão %d não foi encontrado", id));
    }
}
