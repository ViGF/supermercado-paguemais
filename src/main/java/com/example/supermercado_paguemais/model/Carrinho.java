package com.example.supermercado_paguemais.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carrinho")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

}
