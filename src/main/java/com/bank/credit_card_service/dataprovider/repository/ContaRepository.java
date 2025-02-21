package com.bank.credit_card_service.dataprovider.repository;

import com.bank.credit_card_service.dataprovider.entity.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

    Optional<ContaEntity> findByClienteCpf(String cpf);
}
