package com.bank.credit_card_service.dataprovider.implementation;

import com.bank.credit_card_service.dataprovider.mapper.ClienteMapper;
import com.bank.credit_card_service.dataprovider.repository.ClienteRepository;
import com.bank.credit_card_service.usecase.domain.ClienteDomain;
import com.bank.credit_card_service.usecase.exceptions.CpfNaoEncontradoException;
import com.bank.credit_card_service.usecase.exceptions.NegocioException;
import com.bank.credit_card_service.usecase.gateway.ClienteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteDataProvider implements ClienteGateway {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public ClienteDomain cadastrarCliente(ClienteDomain clienteDomain) {
        validaCpf(clienteDomain.getCpf());
        var cliente = clienteRepository.save(ClienteMapper.converteParaEntidade(clienteDomain));
        return ClienteMapper.converteParaDomain(cliente);
    }

    private void validaCpf(String cpf) {
        if (clienteRepository.existsByCpf(cpf)){
            throw new NegocioException("O cpf informado já está cadastrado");
        }
    }
}
