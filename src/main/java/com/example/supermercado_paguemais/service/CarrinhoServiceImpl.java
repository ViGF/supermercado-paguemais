package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoServiceImpl implements CarrinhoService{
    private final CarrinhoRepository repository;

    public CarrinhoServiceImpl(CarrinhoRepository repository) {
        this.repository = repository;
    }


    @Override
    public Carrinho adicionarProduto(Integer idCliente, Integer idProduto, Integer quantidade) {
        return null;
    }

    @Override
    public void removerProduto(Integer idCliente, Integer idProduto) {

    }

    @Override
    public Carrinho atualizarQuantidade(Integer idCliente, Integer idProduto, Integer novaQuantidade) {
        return null;
    }

    @Override
    public List<Carrinho> listarCarrinho(Integer idCliente) {
        return List.of();
    }

    @Override
    public void limparCarrinho(Integer idCliente) {

    }
}
