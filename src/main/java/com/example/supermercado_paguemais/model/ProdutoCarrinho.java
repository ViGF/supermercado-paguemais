package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtocarrinho")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodutocarrinho")
    private Integer idProdutoCarrinho;

    @Column(name = "idcarrinho", nullable = false)
    private Integer idCarrinho;

    @Column(name = "idproduto", nullable = false)
    private Integer idProduto;

    @Column(name = "unidades", nullable = false)
    private Integer unidades;
}
