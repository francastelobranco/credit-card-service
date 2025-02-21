package com.bank.credit_card_service.usecase.exceptions;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;


    public ClienteNaoEncontradoException(Long id) {
        super(String.format("O cliente %d não foi encontrado", id));
    }
}
