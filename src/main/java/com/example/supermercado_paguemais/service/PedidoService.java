package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.MeioPagamento;
import com.example.supermercado_paguemais.model.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido realizarCompra(Integer idCliente);
    List<Pedido> listarPedidosPorCliente(Integer idCliente);
    Pedido buscarPorId(Integer idPedido);
    List<MeioPagamento> listarMeioPagamento();
    MeioPagamento buscarMeioPagamento(Integer id);
}
