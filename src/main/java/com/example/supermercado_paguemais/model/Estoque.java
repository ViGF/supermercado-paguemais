package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodutoestoque")
    private Integer idProdutoEstoque;

    @ManyToOne
    @JoinColumn(name = "idproduto", nullable = false)
    private Produto produto;

    public Integer getIdProdutoEstoque() {
        return idProdutoEstoque;
    }

    public void setIdProdutoEstoque(Integer idProdutoEstoque) {
        this.idProdutoEstoque = idProdutoEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
