package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Integer idCliente;

    @Column(name = "nomecliente", nullable = false)
    private String nomeCliente;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "infocartao", nullable = false)
    private String infoCartao;

    @Column(name = "saldoconta", nullable = false)
    private BigDecimal saldoConta;

    @Column(name = "idendereco", nullable = false)
    private Integer idEndereco;

    @Column(name = "senha", nullable = false)
    private String senha;
}
