package com.bank.credit_card_service.usecase.gateway;

import com.bank.credit_card_service.usecase.domain.ClienteDomain;

public interface ClienteGateway {

    ClienteDomain cadastrarCliente(ClienteDomain clienteDomain);
}
