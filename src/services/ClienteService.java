package services;

import models.Cliente;

public interface ClienteService {
    void cadastrar(Cliente cliente);
    boolean login(String email, String senha);
    Cliente buscarPorId(int id);
    void atualizar(Cliente cliente);
    void deletar(int id);
}
