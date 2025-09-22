package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpedido")
    private Integer idPedido;

    @Column(name = "idcliente", nullable = false)
    private Integer idCliente;

    @Column(name = "idmeiopagamento", nullable = false)
    private Integer idMeioPagamento;

    @Column(name = "idenderecopf", nullable = false)
    private Integer idEndereco;

    @Column(name = "criadoem", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizadoem")
    private LocalDateTime atualizadoEm;

    @Column(name = "valortotal", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "status", length = 50, nullable = false)
    private String status;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdMeioPagamento() {
        return idMeioPagamento;
    }

    public void setIdMeioPagamento(Integer idMeioPagamento) {
        this.idMeioPagamento = idMeioPagamento;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
