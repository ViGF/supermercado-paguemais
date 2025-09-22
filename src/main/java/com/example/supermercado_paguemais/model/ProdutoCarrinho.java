package com.example.supermercado_paguemais.model;

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

    @Column(name = "idcarrinho", nullable = false)
    private Integer idCarrinho;

    @Column(name = "idproduto", nullable = false)
    private Integer idProduto;

    @Column(name = "unidades", nullable = false)
    private Integer unidades;

    public Integer getIdProdutoCarrinho() {
        return idProdutoCarrinho;
    }

    public void setIdProdutoCarrinho(Integer idProdutoCarrinho) {
        this.idProdutoCarrinho = idProdutoCarrinho;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }
}
