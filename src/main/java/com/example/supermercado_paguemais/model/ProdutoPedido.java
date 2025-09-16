package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtopedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodutopedido")
    private Integer idPrdoutoPedido;

    @Column(name = "idpedido", nullable = false)
    private Integer idPedido;

    @Column(name = "idproduto", nullable = false)
    private Integer idProduto;

    @Column(name = "unidades", nullable = false)
    private Integer unidades;
}
