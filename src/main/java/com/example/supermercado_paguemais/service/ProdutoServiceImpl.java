package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Estoque;
import com.example.supermercado_paguemais.model.Produto;
import com.example.supermercado_paguemais.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Produto> listarTodos() {
        return List.of();
    }

    @Override
    public List<Produto> buscarPorNome(String nome) {
        return List.of();
    }

    @Override
    public List<Produto> buscarPorCategoria(String categoria) {
        return List.of();
    }

    @Override
    public Produto atualizarEstoque(Integer idProduto, Integer quantidade) {
        return null;
    }

    @Override
    public Optional<Estoque> buscarEstoquePorProduto(Integer idProduto) {
        return Optional.empty();
    }
}
