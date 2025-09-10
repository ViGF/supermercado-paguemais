package services;

import models.Produto;
import java.util.List;

public interface ProdutoService {
    void cadastrar(Produto produto);
    Produto buscarPorId(int id);
    List<Produto> listarTodos();
    void atualizar(Produto produto);
    void deletar(int id);
}
