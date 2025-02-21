package com.bank.credit_card_service.usecase.service;

import com.bank.credit_card_service.usecase.domain.CartaoDomain;

public interface CartaoService {

    CartaoDomain cadastrarCartaoFisico(CartaoDomain cartao, Long idConta);
    void ativarCartao(Long id);

    void enviarCartaoFisico(Long id);

    void confirmarRecebimento(Long id);

    CartaoDomain cadastrarCartaoVirtual(Long idConta);
}
