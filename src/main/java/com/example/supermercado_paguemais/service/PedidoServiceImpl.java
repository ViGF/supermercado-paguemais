package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.*;
import com.example.supermercado_paguemais.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoServiceImpl(
            PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository,
            CarrinhoRepository carrinhoRepository,
            ProdutoRepository produtoRepository) {

        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    @Override
    public Pedido realizarCompra(Integer idCliente) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Carrinho carrinho = carrinhoRepository.findByCliente(cliente)
                .orElseThrow(() -> new RuntimeException("O cliente não possui um carrinho ativo"));

        if (carrinho.getProdutosCarrinho() == null || carrinho.getProdutosCarrinho().isEmpty()) {
            throw new RuntimeException("Não é possível realizar a compra: o seu carrinho está vazio");
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setEndereco(cliente.getIdEndereco());
        pedido.setCriadoEm(LocalDateTime.now());
        pedido.setAtualizadoEm(LocalDateTime.now());
        pedido.setStatus(StatusPedido.CRIADO);

        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ProdutoCarrinho itemCarrinho : carrinho.getProdutosCarrinho()) {
            Produto produto = itemCarrinho.getProduto();

            if (produto.getUnidades() < itemCarrinho.getUnidades()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNomeProduto());
            }

            ProdutoPedido produtoPedido = new ProdutoPedido();
            produtoPedido.setPedido(pedido);
            produtoPedido.setProduto(produto);
            produtoPedido.setQuantidade(itemCarrinho.getUnidades());
            produtoPedido.setPrecoUnitario(produto.getPrecoProduto());

            pedido.getProdutosPedido().add(produtoPedido);

            valorTotal = valorTotal.add(
                    produto.getPrecoProduto().multiply(BigDecimal.valueOf(itemCarrinho.getUnidades()))
            );
        }

        pedido.setValorTotal(valorTotal);

        return pedidoRepository.save(pedido);
    }
    @Transactional
    @Override
    public Pedido confirmarPedido(Integer idPedido, Pedido dadosPagamento) {

        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (dadosPagamento.getNumeroCartao() == null || dadosPagamento.getNumeroCartao().isBlank()) {
            throw new RuntimeException("Pagamento negado: Número do cartão não informado.");
        }
        if (dadosPagamento.getCvv() == null || dadosPagamento.getCvv().isBlank()) {
            throw new RuntimeException("Pagamento negado: Código CVV é obrigatório.");
        }
        if (pedido.getStatus() != StatusPedido.CRIADO) {
            throw new RuntimeException("Este pedido já foi processado ou está cancelado.");
        }

        pedido.setNumeroCartao(dadosPagamento.getNumeroCartao());
        pedido.setNomeTitular(dadosPagamento.getNomeTitular());
        pedido.setValidade(dadosPagamento.getValidade());
        pedido.setCvv(dadosPagamento.getCvv());
        pedido.setFormaPagamento(dadosPagamento.getFormaPagamento());

        for (ProdutoPedido item : pedido.getProdutosPedido()) {
            Produto produto = item.getProduto();
            if (produto.getUnidades() < item.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para: " + produto.getNomeProduto());
            }
            produto.setUnidades(produto.getUnidades() - item.getQuantidade());
            produtoRepository.save(produto);
        }

        Carrinho carrinho = carrinhoRepository.findByCliente(pedido.getCliente())
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        carrinho.getProdutosCarrinho().clear();
        carrinho.atualizarQuantidadeItens();
        carrinhoRepository.save(carrinho);

        pedido.setStatus(StatusPedido.CONFIRMADO);
        pedido.setAtualizadoEm(LocalDateTime.now());

        return pedidoRepository.save(pedido);
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
                    pedido.setValorTotal(pedidoAtualizado.getValorTotal());
                    pedido.setAtualizadoEm(LocalDateTime.now());
                    return pedidoRepository.save(pedido);
                }).orElseThrow(() ->
                        new RuntimeException("Pedido não encontrado"));
    }

    @Override
    public void deletarPedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
