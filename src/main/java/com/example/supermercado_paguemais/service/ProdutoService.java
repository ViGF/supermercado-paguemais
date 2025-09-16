package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> listarTodos();
    Produto buscarPorId(Integer id);
    void deletar(Integer id);
    void atualizar(Produto produto);
}
