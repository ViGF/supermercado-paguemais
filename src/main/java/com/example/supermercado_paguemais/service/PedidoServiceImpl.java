package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.MeioPagamento;
import com.example.supermercado_paguemais.model.Pedido;
import com.example.supermercado_paguemais.repository.ClienteRepository;
import com.example.supermercado_paguemais.repository.MeioPagamentoRepository;
import com.example.supermercado_paguemais.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final MeioPagamentoRepository meioPagamentoRepository;

    public PedidoServiceImpl(PedidoRepository repository, ClienteRepository clienteRepository, MeioPagamentoRepository meioPagamentoRepository) {
        this.pedidoRepository = repository;
        this.clienteRepository = clienteRepository;
        this.meioPagamentoRepository = meioPagamentoRepository;
    }

    @Override
    public Pedido realizarCompra(Integer idCliente, Integer idMeioPagamento) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
        Optional<MeioPagamento> meioPagamentoOpt = meioPagamentoRepository.findById(idMeioPagamento);

        if(clienteOpt.isEmpty() || meioPagamentoOpt.isEmpty()) {
            throw new RuntimeException("Cliente ou Meio de Pagamento não encontrado!");
        }

        Cliente cliente = clienteOpt.get();
        MeioPagamento meioPagamento = meioPagamentoOpt.get();

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setMeioPagamento(meioPagamento);
        pedido.setValorTotal(BigDecimal.valueOf(0.0));

        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidosPorCliente(Integer idCliente) {
        return pedidoRepository.findByClienteIdCliente(idCliente);
    }

    @Override
    public Pedido buscarPorId(Integer idPedido) {

        return pedidoRepository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
