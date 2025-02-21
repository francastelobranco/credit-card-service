package com.bank.credit_card_service.usecase.service.impl;

import com.bank.credit_card_service.usecase.domain.ClienteDomain;
import com.bank.credit_card_service.usecase.gateway.ClienteGateway;
import com.bank.credit_card_service.usecase.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceServiceImpl implements ClienteService {

    @Autowired
    ClienteGateway clienteGateway;

    @Override
    public ClienteDomain cadastrarCliente(ClienteDomain clienteDomain) {
        return clienteGateway.cadastrarCliente(clienteDomain);
    }
}
