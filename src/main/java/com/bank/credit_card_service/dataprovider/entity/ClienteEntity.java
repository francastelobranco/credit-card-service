package com.bank.credit_card_service.dataprovider.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nomeCliente;

    @Column(nullable = false, length = 100)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String telefone;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    private LocalDateTime dataAlteracao;

    @Embedded
    private Endereco endereco;

    @PrePersist
    private void prePersist() {
        if (this.dataCadastro == null) {
            this.dataCadastro = LocalDateTime.now();
        }
        if ((this.dataAlteracao == null)) {
            this.dataAlteracao = LocalDateTime.now();
        }
    }

    @PreUpdate
    private void preUpdate() {
        this.dataAlteracao = LocalDateTime.now();
    }
}
