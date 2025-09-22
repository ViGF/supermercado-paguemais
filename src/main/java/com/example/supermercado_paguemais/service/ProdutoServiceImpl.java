package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Estoque;
import com.example.supermercado_paguemais.model.Produto;
import com.example.supermercado_paguemais.repository.EstoqueRepository;
import com.example.supermercado_paguemais.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    private final ProdutoRepository produtoRepository;
    private final EstoqueRepository estoqueRepository;

    public ProdutoServiceImpl (ProdutoRepository produtoRepository, EstoqueRepository estoqueRepository) {
        this.produtoRepository = produtoRepository;
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeProdutoContainingIgnoreCase(nome);
    }

    @Override
    public List<Produto> buscarPorCategoria(String categoria) {
        return produtoRepository.findByCategoriaIgnoreCase(categoria);
    }

    @Override
    public Produto atualizarEstoque(Integer idProduto, Integer quantidade) {
        Produto produto = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Estoque não encontrado para o produto " + idProduto));

        produto.setUnidades(quantidade);

        return produtoRepository.save(produto);

    }

    @Override
    public Optional<Estoque> buscarEstoquePorProduto(Integer idProduto) {
        return estoqueRepository.findByProdutoIdProduto(idProduto);
    }
}
