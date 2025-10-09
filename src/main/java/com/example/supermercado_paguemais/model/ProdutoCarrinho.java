package com.example.supermercado_paguemais.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtocarrinho")
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodutocarrinho")
    private Integer idProdutoCarrinho;

    @ManyToOne
    @JoinColumn(name = "idcarrinho", nullable = false)
    @JsonIgnore
    private Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name = "idproduto", nullable = false)
    private Produto produto;

    @Column(name = "unidades", nullable = false)
    private Integer unidades = 0;

    public Integer getIdProdutoCarrinho() {
        return idProdutoCarrinho;
    }

    public void setIdProdutoCarrinho(Integer idProdutoCarrinho) {
        this.idProdutoCarrinho = idProdutoCarrinho;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }
}
