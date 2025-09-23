package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {
    private final CarrinhoRepository repository;

    public CarrinhoServiceImpl(CarrinhoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Carrinho adicionarProduto(Integer idCliente, Integer idProduto, Integer quantidade) {
        return repository.findByIdClienteAndIdProduto(idCliente, idProduto)
                .map(item -> {
                    item.setQuantidadeItens(item.getQuantidadeItens() + quantidade);
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    Carrinho novoItem = new Carrinho();
                    novoItem.setIdCliente(idCliente);
                    novoItem.setIdProduto(idProduto);
                    novoItem.setQuantidadeItens(quantidade);
                    return repository.save(novoItem);
                });
    }

    @Override
    public void removerProduto(Integer idCliente, Integer idProduto) {
        repository.findByIdClienteAndIdProduto(idCliente, idProduto)
                .ifPresent(repository::delete);
    }

    @Override
    public Carrinho atualizarQuantidade(Integer idCliente, Integer idProduto, Integer novaQuantidade) {
        return repository.findByIdClienteAndIdProduto(idCliente, idProduto)
                .map(item -> {
                    item.setQuantidadeItens(novaQuantidade); // vai substitui pela nova quantidade
                    return repository.save(item);
                })
                .orElse(null);
    }

    @Override
    public List<Carrinho> listarCarrinho(Integer idCliente) {
        return repository.findByIdCliente(idCliente);
    }

    @Override
    public void limparCarrinho(Integer idCliente) {
        List<Carrinho> itens = repository.findByIdCliente(idCliente);
        repository.deleteAll(itens);
    }
}
