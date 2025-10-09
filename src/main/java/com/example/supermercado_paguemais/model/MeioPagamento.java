package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "meiopagamento")
@NoArgsConstructor
@AllArgsConstructor
public class MeioPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmeiopagamento")
    private Integer idMeioPagamento;

    @ManyToOne
    @JoinColumn(name = "idcartao")
    private Cartao cartao;

    public Integer getIdMeioPagamento() {
        return idMeioPagamento;
    }

    public void setIdMeioPagamento(Integer idMeioPagamento) {
        this.idMeioPagamento = idMeioPagamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
