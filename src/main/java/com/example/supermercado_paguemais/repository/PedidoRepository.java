package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
