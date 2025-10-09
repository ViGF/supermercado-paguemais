package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Endereco;
import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.model.Pedido;
import com.example.supermercado_paguemais.repository.ClienteRepository;
import com.example.supermercado_paguemais.repository.EnderecoRepository;
import com.example.supermercado_paguemais.repository.CarrinhoRepository;
import com.example.supermercado_paguemais.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final CarrinhoRepository carrinhoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, CarrinhoRepository carrinhoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.carrinhoRepository = carrinhoRepository;
    }

    @Override
    public Pedido realizarCompra(Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getIdCliente())
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        Endereco endereco = enderecoRepository.findById(pedido.getEndereco().getIdEndereco())
                        .orElseThrow(() -> new RuntimeException("Endereço não encontrado!"));
        Carrinho carrinho = carrinhoRepository.findByCliente(cliente)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado para este cliente!"));

        BigDecimal valorTotal = carrinho.getProdutosCarrinho().stream()
                .map(item -> item.getProduto().getPrecoProduto()
                        .multiply(BigDecimal.valueOf(item.getUnidades())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setCliente(cliente);
        pedido.setEndereco(endereco);
        pedido.setValorTotal(valorTotal);
        pedido.setCriadoEm(LocalDateTime.now());
        pedido.setStatus("PENDENTE");

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        carrinho.getProdutosCarrinho().clear();
        carrinhoRepository.save(carrinho);

        return pedidoSalvo;
    }

    @Override
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> buscarPorId(Integer idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    @Override
    public Pedido atualizarPedido(Integer id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setStatus(pedidoAtualizado.getStatus());
                    pedido.setAtualizadoEm(LocalDateTime.now());
                    return pedidoRepository.save(pedido);
                }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @Override
    public void deletarPedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
