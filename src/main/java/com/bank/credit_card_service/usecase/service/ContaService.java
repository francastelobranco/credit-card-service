package com.bank.credit_card_service.usecase.service;

import com.bank.credit_card_service.usecase.domain.ContaDomain;

public interface ContaService {

    ContaDomain criar(ContaDomain conta);
    ContaDomain buscarConta(Long id);
    ContaDomain buscarPorCpf(String cpf);
    void inativatConta(Long id);
}
