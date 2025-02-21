package com.bank.credit_card_service.dataprovider.implementation;

import com.bank.credit_card_service.dataprovider.entity.ContaEntity;
import com.bank.credit_card_service.dataprovider.enums.StatusContaEnum;
import com.bank.credit_card_service.dataprovider.mapper.ContaMapper;
import com.bank.credit_card_service.dataprovider.repository.ClienteRepository;
import com.bank.credit_card_service.dataprovider.repository.ContaRepository;
import com.bank.credit_card_service.usecase.domain.ContaDomain;
import com.bank.credit_card_service.usecase.exceptions.ContaNaoEncontradaException;
import com.bank.credit_card_service.usecase.exceptions.CpfNaoEncontradoException;
import com.bank.credit_card_service.usecase.gateway.ContaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaDataProvider implements ContaGateway {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public ContaDomain criar(ContaDomain conta) {
        var cliente = clienteRepository.findById(conta.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        var contaEntity = ContaMapper.converteParaEntidade(conta);

        contaEntity.setCliente(cliente);

        contaEntity = contaRepository.save(contaEntity);


        return ContaMapper.converteParaDomain(contaEntity);
    }

    @Override
    public ContaDomain buscarConta(Long id) {
        var conta = buscaContaPorId(id);
        return ContaMapper.converteParaDomain(conta);
    }

    @Override
    public ContaDomain buscarPorCpf(String cpf) {
        var conta = contaRepository
                .findByClienteCpf(cpf)
                .orElseThrow(() -> new CpfNaoEncontradoException(cpf));
        return ContaMapper.converteParaDomain(conta);

    }

    @Override
    public void inativatConta(Long id) {
        var conta = buscaContaPorId(id);
        conta.setStatus(StatusContaEnum.INATIVA);
        contaRepository.save(conta);
    }

    private ContaEntity buscaContaPorId(Long id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new ContaNaoEncontradaException(id));
    }
}
