package com.bank.credit_card_service.dataprovider.implementation;

import com.bank.credit_card_service.dataprovider.entity.CartaoEntity;
import com.bank.credit_card_service.dataprovider.enums.StatusCartaoEnum;
import com.bank.credit_card_service.dataprovider.enums.StatusEnvioEnum;
import com.bank.credit_card_service.dataprovider.enums.TipoCartao;
import com.bank.credit_card_service.dataprovider.mapper.CartaoMapper;
import com.bank.credit_card_service.dataprovider.repository.CartaoRepository;
import com.bank.credit_card_service.dataprovider.repository.ContaRepository;
import com.bank.credit_card_service.usecase.domain.CartaoDomain;
import com.bank.credit_card_service.usecase.exceptions.CartaoNaoEncontradoException;
import com.bank.credit_card_service.usecase.exceptions.ContaNaoEncontradaException;
import com.bank.credit_card_service.usecase.gateway.CartaoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CartaoDataProvider implements CartaoGateway {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    ContaRepository contaRepository;

    @Override
    public CartaoDomain cadastrarCartaoFisico(CartaoDomain cartao, Long idConta) {
        var conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new ContaNaoEncontradaException(idConta));

        var cartaoEntity = CartaoMapper.converteParaEntidade(cartao);
        cartaoEntity.setContaId(idConta);
        cartaoEntity.setNomeTitular(conta.getCliente().getNomeCliente());
        cartaoEntity.setStatusEnvio(StatusEnvioEnum.PENDENTE);
        cartaoEntity.setTipoCartao(TipoCartao.FISICO);
        cartaoEntity = cartaoRepository.save(cartaoEntity);

        conta.getCartoes().add(cartaoEntity);
        contaRepository.save(conta);

        return CartaoMapper.converteParaDomain(cartaoEntity);
    }
    @Override
    public CartaoDomain cadastrarCartaoVirtual(CartaoDomain cartaoFisico,Long idConta) {
        var conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new ContaNaoEncontradaException(idConta));

        var cartaoVirtual = new CartaoEntity();

        var primeirosDigitos = cartaoFisico.getNumero().substring(0, 4);
        var novosDigitos = String.format("%012d", (long) (Math.random() * 1_000_000_000_000L));

        cartaoVirtual.setContaId(idConta);
        cartaoVirtual.setNumero(primeirosDigitos.concat(novosDigitos));
        cartaoVirtual.setNomeTitular(cartaoFisico.getNomeTitular());
        cartaoVirtual.setDataValidade(LocalDate.now().plusYears(5));
        cartaoVirtual.setBandeira(cartaoFisico.getBandeira());
        cartaoVirtual.setStatusCartao(StatusCartaoEnum.ATIVO);
        cartaoVirtual.setTipoCartao(TipoCartao.VIRTUAL);

        var cartaoVirtualCriado = cartaoRepository.save(cartaoVirtual);

        conta.getCartoes().add(cartaoVirtualCriado);

        contaRepository.save(conta);

        return CartaoMapper.converteParaDomain(cartaoVirtualCriado);
    }



    @Override
    public void ativarCartao(CartaoDomain cartao) {
        cartaoRepository.save(CartaoMapper.converteParaEntidade(cartao));
    }

    @Override
    public CartaoDomain buscarPorId(Long id) {
        var cartao =  cartaoRepository.findById(id).orElseThrow(() -> new CartaoNaoEncontradoException(id));
        return CartaoMapper.converteParaDomain(cartao);
    }

    @Override
    public void atualizarCartao(CartaoDomain cartaoDomain) {
        var cartao = CartaoMapper.converteParaEntidade(cartaoDomain);
        cartaoRepository.save(cartao);
    }




}
