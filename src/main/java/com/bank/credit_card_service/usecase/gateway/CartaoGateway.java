package com.bank.credit_card_service.usecase.gateway;

import com.bank.credit_card_service.usecase.domain.CartaoDomain;

public interface CartaoGateway {

    CartaoDomain cadastrarCartaoFisico(CartaoDomain cartao, Long idConta);
    void ativarCartao(CartaoDomain cartaoDomain);

    CartaoDomain buscarPorId(Long id);
    void atualizarCartao(CartaoDomain cartaoDomain);

    CartaoDomain cadastrarCartaoVirtual(CartaoDomain cartaoDomain,Long idConta);
}
