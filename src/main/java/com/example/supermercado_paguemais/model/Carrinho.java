package com.example.supermercado_paguemais.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "carrinho")
@NoArgsConstructor
@AllArgsConstructor
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrinho")
    private Long idCarrinho;

    @OneToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Cliente cliente;

    @Column(name = "quantidadeitens", nullable = false)
    private Integer quantidadeItens = 0;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoCarrinho> produtosCarrinho;

    public void atualizarQuantidadeItens() {
        this.quantidadeItens = produtosCarrinho.stream()
                .mapToInt(ProdutoCarrinho::getUnidades)
                .sum();
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente idCliente) {
        this.cliente = idCliente;
    }

    public List<ProdutoCarrinho> getProdutosCarrinho() {
        return produtosCarrinho;
    }

    public void setProdutosCarrinho(List<ProdutoCarrinho> produtosCarrinho) {
        this.produtosCarrinho = produtosCarrinho;
    }

    public Integer getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(Integer quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }
}
