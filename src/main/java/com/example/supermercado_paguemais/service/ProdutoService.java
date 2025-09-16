package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Estoque;
import com.example.supermercado_paguemais.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    Optional<Produto> buscarPorId(Integer id);
    List<Produto> listarTodos();
    List<Produto> buscarPorNome(String nome);
    List<Produto> buscarPorCategoria(String categoria);
    Produto atualizarEstoque(Integer idProduto, Integer quantidade);
    Optional<Estoque> buscarEstoquePorProduto(Integer idProduto);
}
