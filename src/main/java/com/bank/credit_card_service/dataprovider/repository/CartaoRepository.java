package com.bank.credit_card_service.dataprovider.repository;

import com.bank.credit_card_service.dataprovider.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {
}
