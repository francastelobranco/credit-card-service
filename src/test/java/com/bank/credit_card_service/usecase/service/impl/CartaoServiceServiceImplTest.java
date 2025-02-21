package com.bank.credit_card_service.usecase.service.impl;

import com.bank.credit_card_service.dataprovider.enums.StatusEnvioEnum;
import com.bank.credit_card_service.dataprovider.enums.TipoCartao;
import com.bank.credit_card_service.usecase.domain.CartaoDomain;
import com.bank.credit_card_service.usecase.domain.ContaDomain;
import com.bank.credit_card_service.usecase.exceptions.NegocioException;
import com.bank.credit_card_service.usecase.gateway.CartaoGateway;
import com.bank.credit_card_service.usecase.gateway.ContaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CartaoServiceServiceImplTest {

    @Mock
    private CartaoGateway cartaoGateway;

    @Mock
    private ContaGateway contaGateway;

    @InjectMocks
    private CartaoServiceServiceImpl cartaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarCartaoFisico() {
        var cartao = new CartaoDomain();

        var conta = mock(ContaDomain.class);

        when(conta.getCartoes()).thenReturn(List.of());
        when(contaGateway.buscarConta(anyLong())).thenReturn(conta);
        when(cartaoGateway.cadastrarCartaoFisico(any(), anyLong())).thenReturn(cartao);

        var resultado = cartaoService.cadastrarCartaoFisico(cartao, 1L);
        assertNotNull(resultado);
    }

    @Test
    void deveLancarExcecaoQuandoContaJaPossuiCartaoFisico() {
        var cartao = new CartaoDomain();
        cartao.setTipoCartao(TipoCartao.FISICO.toString());

        var conta = mock(ContaDomain.class);

        when(conta.getCartoes()).thenReturn(List.of(cartao));
        when(contaGateway.buscarConta(anyLong())).thenReturn(conta);

        assertThrows(NegocioException.class, () -> cartaoService.cadastrarCartaoFisico(new CartaoDomain(), 1L));
    }

    @Test
    void deveAtivarCartaoQuandoRecebido() {
        var cartao = new CartaoDomain();
        cartao.setStatusEnvio(StatusEnvioEnum.RECEBIDO.toString());
        when(cartaoGateway.buscarPorId(anyLong())).thenReturn(cartao);

        cartaoService.ativarCartao(1L);
        verify(cartaoGateway, times(1)).ativarCartao(cartao);
    }

    @Test
    void deveLancarExcecaoQuandoCartaoNaoFoiRecebido() {
        var cartao = new CartaoDomain();
        cartao.setStatusEnvio(StatusEnvioEnum.ENVIADO.toString());
        when(cartaoGateway.buscarPorId(anyLong())).thenReturn(cartao);

        assertThrows(NegocioException.class, () -> cartaoService.ativarCartao(1L));
    }
}