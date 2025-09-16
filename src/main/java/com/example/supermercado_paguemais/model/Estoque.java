package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estoque")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodutoestoque")
    private Integer idProdutoEstoque;

    @Column(name = "idproduto", nullable = false)
    private Integer idProduto;
}
