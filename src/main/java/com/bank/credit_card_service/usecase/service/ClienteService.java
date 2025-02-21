package com.bank.credit_card_service.usecase.service;

import com.bank.credit_card_service.usecase.domain.ClienteDomain;

public interface ClienteService {

    ClienteDomain cadastrarCliente(ClienteDomain clienteDomain);
}
