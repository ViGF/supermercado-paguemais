package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduto")
    private Integer idProduto;

    @Column(name = "nomeproduto", nullable = false)
    private String nomeProduto;

    @Column(name = "precoproduto", nullable = false)
    private Double precoProduto;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "unidades", nullable = false)
    private Integer unidades;
}
