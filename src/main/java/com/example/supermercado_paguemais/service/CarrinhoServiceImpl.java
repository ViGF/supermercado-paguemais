package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Produto;
import com.example.supermercado_paguemais.model.ProdutoCarrinho;
import com.example.supermercado_paguemais.repository.CarrinhoRepository;
import com.example.supermercado_paguemais.repository.ClienteRepository;
import com.example.supermercado_paguemais.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    public CarrinhoServiceImpl(CarrinhoRepository carrinhoRepository,
                               ProdutoRepository produtoRepository,
                               ClienteRepository clienteRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Carrinho adicionarProduto(Integer idCliente, Integer idProduto, Integer quantidade) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Carrinho carrinho = carrinhoRepository.findByClienteAndProduto(cliente, produto)
                .orElseGet(() -> {
                    Carrinho novoItem = new Carrinho();
                    novoItem.setCliente(cliente);

                    ProdutoCarrinho pc = new ProdutoCarrinho();
                    pc.setProduto(produto);
                    pc.setCarrinho(novoItem);
                    pc.setUnidades(quantidade);

                    novoItem.setProdutosCarrinho(new ArrayList<>());
                    novoItem.getProdutosCarrinho().add(pc);
                    novoItem.atualizarQuantidadeItens();

                    return novoItem;
                });

        ProdutoCarrinho produtoCarrinho = carrinho.getProdutosCarrinho().stream()
                .filter(pc -> pc.getProduto().getIdProduto().equals(produto.getIdProduto()))
                .findFirst()
                .orElseGet(() -> {
                    ProdutoCarrinho pc = new ProdutoCarrinho();
                    pc.setProduto(produto);
                    pc.setCarrinho(carrinho);
                    pc.setUnidades(0);
                    carrinho.getProdutosCarrinho().add(pc);
                    return pc;
                });

        produtoCarrinho.setUnidades(produtoCarrinho.getUnidades() + quantidade);
        carrinho.atualizarQuantidadeItens();

        return carrinhoRepository.save(carrinho);
    }


    @Override
    public void removerProduto(Integer idCliente, Integer idProduto) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        carrinhoRepository.findByClienteAndProduto(cliente, produto)
                .ifPresent(carrinhoRepository::delete);
    }

    @Override
    public Carrinho atualizarQuantidade(Integer idCliente, Integer idProduto, Integer novaQuantidade) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return carrinhoRepository.findByClienteAndProduto(cliente, produto)
                .map(item -> {
                    item.setQuantidadeItens(novaQuantidade);
                    return carrinhoRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no carrinho"));
    }

    @Override
    public Optional<Carrinho> listarCarrinho(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return carrinhoRepository.findByCliente(cliente);
    }

    @Override
    public void limparCarrinho(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        carrinhoRepository.findByCliente(cliente).ifPresent(carrinho -> {
            carrinho.getProdutosCarrinho().clear();
            carrinhoRepository.save(carrinho);
        });
    }

}
