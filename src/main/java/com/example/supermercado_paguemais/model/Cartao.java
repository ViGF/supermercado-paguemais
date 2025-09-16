package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "cartao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcartao")
    private Integer idCartao;

    @Column(name = "nomenocartao", nullable = false)
    private String nomeNoCartao;

    @Column(name = "numerocartao", nullable = false)
    private String numeroCartao;

    @Column(name = "validade", nullable = false)
    private Date validade;
}
