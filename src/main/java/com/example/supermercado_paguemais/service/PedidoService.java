package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    Pedido realizarCompra(Integer idCliente);
    Pedido confirmarPedido(Integer idPedido, Pedido dadosPagamento);
    List<Pedido> listarTodos();
    Optional<Pedido> buscarPorId(Integer idPedido);
    Pedido atualizarPedido(Integer id, Pedido pedidoAtualizado);
    void deletarPedido(Integer id);
}
