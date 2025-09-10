package services;

import models.Produto;

public interface EstoqueService {
    void adicionarProduto(Produto produto, int quantidade);
    void removerProduto(int idProduto, int quantidade);
    int consultarEstoque(int idProduto);
}
