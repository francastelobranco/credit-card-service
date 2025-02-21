package com.bank.credit_card_service.usecase.service.impl;

import com.bank.credit_card_service.dataprovider.enums.StatusCartaoEnum;
import com.bank.credit_card_service.dataprovider.enums.StatusEnvioEnum;
import com.bank.credit_card_service.dataprovider.enums.TipoCartao;
import com.bank.credit_card_service.usecase.domain.CartaoDomain;
import com.bank.credit_card_service.usecase.exceptions.NegocioException;
import com.bank.credit_card_service.usecase.gateway.CartaoGateway;
import com.bank.credit_card_service.usecase.gateway.ContaGateway;
import com.bank.credit_card_service.usecase.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CartaoServiceServiceImpl implements CartaoService {

    @Autowired
    CartaoGateway cartaoGateway;

    @Autowired
    ContaGateway contaGateway;

    @Override
    public CartaoDomain cadastrarCartaoFisico(CartaoDomain cartao, Long idConta) {
        var conta = contaGateway.buscarConta(idConta);

        if (!conta.getCartoes().isEmpty()) {
            for(CartaoDomain c : conta.getCartoes()) {
                if (c.getTipoCartao().equals(TipoCartao.FISICO.toString())){
                    throw new NegocioException("A conta informada já possui cartão físico.");
                }
                break;
            }
        }

        cartao.setDataValidade(LocalDate.now().plusYears(5));
        cartao.inativar();
        cartao.pendente();
        return cartaoGateway.cadastrarCartaoFisico(cartao, idConta);
    }

    @Override
    public CartaoDomain cadastrarCartaoVirtual(Long idConta) {
        var conta = contaGateway.buscarConta(idConta);
        var cartaoFisico = new CartaoDomain();

        if (conta.getCartoes().isEmpty()) {
            throw new NegocioException("Não existe cartão físico para o cliente informado.");
        }

        for(CartaoDomain cartao : conta.getCartoes()) {
            if (cartao.getTipoCartao().equals(TipoCartao.FISICO.toString())){
                if (!cartao.getStatusCartao().equals(StatusCartaoEnum.ATIVO.toString())){
                    throw new NegocioException("O cartão físico não está ativo");
                }
                cartaoFisico = cartao;
                break;
            }
        }

        var cartaoVirtual = cartaoGateway.cadastrarCartaoVirtual(cartaoFisico,idConta);
        return cartaoVirtual;

    }

    @Override
    public void ativarCartao(Long id) {
        var cartao = cartaoGateway.buscarPorId(id);
        if (!cartao.getStatusEnvio().equals(StatusEnvioEnum.RECEBIDO.toString())) {
            throw new NegocioException("O cartão informado está com recebimento pendente");
        }
        cartao.ativar();
        cartaoGateway.ativarCartao(cartao);
    }

    @Override
    public void enviarCartaoFisico(Long id) {
        var cartao = cartaoGateway.buscarPorId(id);
        cartao.enviar();
        cartaoGateway.atualizarCartao(cartao);
    }

    @Override
    public void confirmarRecebimento(Long id) {
        var cartao = cartaoGateway.buscarPorId(id);
        if (!cartao.getStatusEnvio().equals(StatusEnvioEnum.ENVIADO.toString())) {
            throw new NegocioException("O cartão informado está com envio pendente");
        }
        cartao.receber();
        cartaoGateway.atualizarCartao(cartao);
    }
}
