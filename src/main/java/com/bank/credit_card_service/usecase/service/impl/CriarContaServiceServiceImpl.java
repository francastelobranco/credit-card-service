package com.bank.credit_card_service.usecase.service.impl;

import com.bank.credit_card_service.usecase.domain.ContaDomain;
import com.bank.credit_card_service.usecase.gateway.ContaGateway;
import com.bank.credit_card_service.usecase.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarContaServiceServiceImpl implements ContaService {

    @Autowired
    ContaGateway contaGateway;

    public ContaDomain criar(ContaDomain conta) {
        conta.habilitarConta();
        return contaGateway.criar(conta);
    }

    @Override
    public ContaDomain buscarConta(Long id) {
        return contaGateway.buscarConta(id);
    }

    @Override
    public ContaDomain buscarPorCpf(String cpf) {
        return contaGateway.buscarPorCpf(cpf);
    }

    @Override
    public void inativatConta(Long id) {
        contaGateway.inativatConta(id);
    }
}
