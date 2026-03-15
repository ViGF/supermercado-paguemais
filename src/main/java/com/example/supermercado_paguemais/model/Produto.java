package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduto")
    private Integer idProduto;

    @Column(name = "nomeproduto", nullable = false)
    private String nomeProduto;

    @Column(name = "precoproduto", nullable = false)
    private BigDecimal precoProduto;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "unidades", nullable = false)
    private Integer unidades;

    @Column(name = "imagemcapa")
    private String imgCapa;

    public Produto(String nomeProduto, BigDecimal precoProduto, String categoria, Integer unidades) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.categoria = categoria;
        this.unidades = unidades;
    }


    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public String getImgCapa() {
        return imgCapa;
    }

    public void setImgCapa(String imgCapa) {
        this.imgCapa = imgCapa;
    }
}
