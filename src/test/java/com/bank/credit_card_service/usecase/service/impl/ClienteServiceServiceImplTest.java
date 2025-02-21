package com.bank.credit_card_service.usecase.service.impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.bank.credit_card_service.usecase.domain.ClienteDomain;
import com.bank.credit_card_service.usecase.gateway.ClienteGateway;
import com.bank.credit_card_service.usecase.service.impl.ClienteServiceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

class ClienteServiceServiceImplTest {

    @Mock
    private ClienteGateway clienteGateway;

    @InjectMocks
    private ClienteServiceServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarCliente() {
        ClienteDomain clienteMock = new ClienteDomain(
                1L, "Nome Cliente", "12345678900", "email@email.com",
                "11999999999", LocalDateTime.now(), LocalDateTime.now(),
                null, null
        );
        when(clienteGateway.cadastrarCliente(any())).thenReturn(clienteMock);

        ClienteDomain cliente = clienteService.cadastrarCliente(clienteMock);
        assertNotNull(cliente);
        verify(clienteGateway, times(1)).cadastrarCliente(any());
    }
}