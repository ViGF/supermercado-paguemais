package services;

import models.Carrinho;
import models.Produto;

public interface CarrinhoService {
    void adicionarProduto(Carrinho carrinho, Produto produto, int quantidade);
    void removerProduto(Carrinho carrinho, Produto produto);
    double calcularTotal(Carrinho carrinho);
}
