package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Carrinho;

public interface CarrinhoService {
    Carrinho adicionarProduto(Integer idCliente, Integer idProduto, Integer quantidade);
    void removerProduto(Integer idCliente, Integer idProduto);
    Carrinho atualizarQuantidade(Integer idCliente, Integer idProduto, Integer novaQuantidade);
    Carrinho listarCarrinho(Integer idCliente);
    void limparCarrinho(Integer idCliente);
}
