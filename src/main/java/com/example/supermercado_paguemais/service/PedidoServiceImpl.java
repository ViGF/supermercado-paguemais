package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Pedido;
import com.example.supermercado_paguemais.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{
    private final PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido realizarCompra(Integer idCliente, Integer idMeioPagamento) {
        return null;
    }

    @Override
    public List<Pedido> listarPedidosPorCliente(Integer idCliente) {
        return List.of();
    }

    @Override
    public Pedido buscarPorId(Integer idPedido) {
        return null;
    }
}
