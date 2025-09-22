package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtopedido")
@NoArgsConstructor
@AllArgsConstructor
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

    public Integer getIdPrdoutoPedido() {
        return idPrdoutoPedido;
    }

    public void setIdPrdoutoPedido(Integer idPrdoutoPedido) {
        this.idPrdoutoPedido = idPrdoutoPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
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
