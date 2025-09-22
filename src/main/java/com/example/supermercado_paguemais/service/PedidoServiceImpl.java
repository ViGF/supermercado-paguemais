package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Pedido;
import com.example.supermercado_paguemais.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido realizarCompra(Integer idCliente, Integer idMeioPagamento) {
        Pedido pedido = new Pedido();
        pedido.setIdCliente(idCliente);
        pedido.setIdMeioPagamento(idMeioPagamento);
        pedido.setDataHora(LocalDateTime.now());

        // aqui você pode calcular o valor total baseado no carrinho do cliente
        // por enquanto, vou deixar como 0.0
        pedido.setValorTotal(0.0);

        return repository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidosPorCliente(Integer idCliente) {
        return repository.findByIdCliente(idCliente);
    }

    @Override
    public Pedido buscarPorId(Integer idPedido) {
        return repository.findById(idPedido).orElse(null);
    }
}
