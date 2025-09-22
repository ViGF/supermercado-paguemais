package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carrinho")
@NoArgsConstructor
@AllArgsConstructor
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrinho")
    private Integer idCarrinho;

    @Column(name = "idcliente", nullable = false)
    private Integer idCliente;

    @Column(name = "idproduto", nullable = false)
    private Integer idProduto;

    @Column(name = "quantidadeitens", nullable = false)
    private int quantidadeItens;

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }
}
