package com.bank.credit_card_service.usecase.service.impl;

import com.bank.credit_card_service.dataprovider.enums.StatusContaEnum;
import com.bank.credit_card_service.usecase.domain.ClienteDomain;
import com.bank.credit_card_service.usecase.domain.ContaDomain;
import com.bank.credit_card_service.usecase.gateway.ContaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CriarContaServiceServiceImplTest {

    @Mock
    private ContaGateway contaGateway;

    @InjectMocks
    private CriarContaServiceServiceImpl contaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private ContaDomain criarContaMock() {
        return ContaDomain.builder()
                .id(1L)
                .agencia("1234")
                .conta("56789")
                .dataCadastro(LocalDateTime.now())
                .dataAlteracao(LocalDateTime.now())
                .status(StatusContaEnum.ATIVA)
                .cartoes(Collections.emptyList())
                .cliente(ClienteDomain.builder().id(1L).build())
                .build();
    }

    @Test
    void deveCriarConta() {
        ContaDomain contaMock = criarContaMock();
        when(contaGateway.criar(any())).thenReturn(contaMock);

        ContaDomain conta = contaService.criar(criarContaMock());
        assertNotNull(conta);
        verify(contaGateway, times(1)).criar(any());
    }

    @Test
    void deveBuscarContaPorId() {
        ContaDomain contaMock = criarContaMock();
        when(contaGateway.buscarConta(anyLong())).thenReturn(contaMock);

        ContaDomain conta = contaService.buscarConta(1L);
        assertNotNull(conta);
        verify(contaGateway, times(1)).buscarConta(anyLong());
    }

    @Test
    void deveBuscarContaPorCpf() {
        ContaDomain contaMock = criarContaMock();
        when(contaGateway.buscarPorCpf(anyString())).thenReturn(contaMock);

        ContaDomain conta = contaService.buscarPorCpf("12345678900");
        assertNotNull(conta);
        verify(contaGateway, times(1)).buscarPorCpf(anyString());
    }

    @Test
    void deveInativarConta() {
        doNothing().when(contaGateway).inativatConta(anyLong());

        contaService.inativatConta(1L);
        verify(contaGateway, times(1)).inativatConta(anyLong());
    }
}