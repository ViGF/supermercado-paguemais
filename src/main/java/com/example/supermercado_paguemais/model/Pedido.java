package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpedido")
    private Integer idPedido;

    @Column(name = "idcliente", nullable = false)
    private Integer idCliente;

    @Column(name = "idmeiopagamento", nullable = false)
    private Integer idMeioPagamento;

    @Column(name = "idenderecopf", nullable = false)
    private Integer idEndereco;

    @Column(name = "criadoem", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizadoem")
    private LocalDateTime atualizadoEm;

    @Column(name = "valortotal", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "status", length = 50, nullable = false)
    private String status;
}
