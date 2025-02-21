package com.bank.credit_card_service.dataprovider.entity;

import com.bank.credit_card_service.dataprovider.enums.BandeiraEnum;
import com.bank.credit_card_service.dataprovider.enums.StatusCartaoEnum;
import com.bank.credit_card_service.dataprovider.enums.StatusEnvioEnum;
import com.bank.credit_card_service.dataprovider.enums.TipoCartao;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "tb_cartao")
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 16)
    private String numero;

    @Column(nullable = false, length = 100)
    private String nomeTitular;

    @Column(nullable = false)
    private LocalDate dataValidade;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;

    @Enumerated(EnumType.STRING)
    private StatusCartaoEnum statusCartao;

    @Enumerated(EnumType.STRING)
    private StatusEnvioEnum statusEnvio;

    @Enumerated(EnumType.STRING)
    private BandeiraEnum bandeira;

    @Enumerated(EnumType.STRING)
    private TipoCartao tipoCartao;

    @Column(name = "conta_id", nullable = false)
    private Long contaId;
}
