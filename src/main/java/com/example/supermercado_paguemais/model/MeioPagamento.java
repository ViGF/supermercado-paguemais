package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meiopagamento")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MeioPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmeiopagamento")
    private Integer idMeioPagamento;

    @Column(name = "idcliente", nullable = false)
    private Integer idCliente;
}
