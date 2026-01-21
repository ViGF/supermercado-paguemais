package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Produto;
import com.example.supermercado_paguemais.model.ProdutoCarrinho;
import com.example.supermercado_paguemais.repository.CarrinhoRepository;
import com.example.supermercado_paguemais.repository.ClienteRepository;
import com.example.supermercado_paguemais.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    @Transactional
    public Carrinho adicionarProduto(Integer idCliente, Integer idProduto, Integer quantidade) {

        if (quantidade <= 0) {
            throw new RuntimeException("Quantidade inválida");
        }

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Carrinho carrinho = carrinhoRepository.findByCliente(cliente)
                .orElseGet(() -> {
                    Carrinho novo = new Carrinho();
                    novo.setCliente(cliente);
                    novo.setProdutosCarrinho(new ArrayList<>());
                    novo.setQuantidadeItens(0);
                    return novo;
                });

        ProdutoCarrinho produtoCarrinho = carrinho.getProdutosCarrinho()
                .stream()
                .filter(pc -> pc.getProduto().getIdProduto().equals(idProduto))
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
    @Transactional
    public Carrinho atualizarQuantidade(Integer idCliente, Integer idProduto, Integer novaQuantidade) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Carrinho carrinho = carrinhoRepository.findByCliente(cliente)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        ProdutoCarrinho produtoCarrinho = carrinho.getProdutosCarrinho()
                .stream()
                .filter(pc -> pc.getProduto().getIdProduto().equals(idProduto))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no carrinho"));

        if (novaQuantidade <= 0) {
            carrinho.getProdutosCarrinho().remove(produtoCarrinho);
        } else {
            produtoCarrinho.setUnidades(novaQuantidade);
        }

        carrinho.atualizarQuantidadeItens();

        return carrinhoRepository.save(carrinho);
    }

    @Override
    @Transactional
    public void removerProduto(Integer idCliente, Integer idProduto) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Carrinho carrinho = carrinhoRepository.findByCliente(cliente)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        boolean removido = carrinho.getProdutosCarrinho()
                .removeIf(pc -> pc.getProduto().getIdProduto().equals(idProduto));

        if (!removido) {
            throw new RuntimeException("Produto não encontrado no carrinho");
        }

        carrinho.atualizarQuantidadeItens();
        carrinhoRepository.save(carrinho);
    }

    @Override
    public Carrinho listarCarrinho(Integer idCliente) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return carrinhoRepository.findByCliente(cliente)
                .orElseThrow(() -> new RuntimeException("Carrinho vazio"));
    }

    @Override
    @Transactional
    public void limparCarrinho(Integer idCliente) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Carrinho carrinho = carrinhoRepository.findByCliente(cliente)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        carrinho.getProdutosCarrinho().clear();
        carrinho.atualizarQuantidadeItens();

        carrinhoRepository.save(carrinho);
    }
}
