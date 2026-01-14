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
import java.util.List;

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

        Carrinho carrinho = carrinhoRepository.findFirstByCliente(cliente)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        ProdutoCarrinho produtoCarrinho = carrinho.getProdutosCarrinho()
                .stream()
                .filter(pc -> pc.getProduto().getIdProduto().equals(idProduto))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no carrinho"));

        // atualiza unidades do produto
        produtoCarrinho.setUnidades(novaQuantidade);

        // recalcula total de itens do carrinho
        carrinho.atualizarQuantidadeItens();

        return carrinhoRepository.save(carrinho);
    }




    @Override
    public List<Carrinho> listarCarrinho(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return carrinhoRepository.findAllByCliente(cliente);
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
