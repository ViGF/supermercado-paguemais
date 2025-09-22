package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meiopagamento")
@NoArgsConstructor
@AllArgsConstructor
public class MeioPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmeiopagamento")
    private Integer idMeioPagamento;

    @Column(name = "idcliente", nullable = false)
    private Integer idCliente;

    public Integer getIdMeioPagamento() {
        return idMeioPagamento;
    }

    public void setIdMeioPagamento(Integer idMeioPagamento) {
        this.idMeioPagamento = idMeioPagamento;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
