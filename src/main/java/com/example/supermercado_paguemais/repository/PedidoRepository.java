package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByIdCliente(Integer idCliente);
}
