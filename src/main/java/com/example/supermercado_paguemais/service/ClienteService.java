package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cliente;

import java.util.List;

public interface ClienteService {
    void cadastrarCliente(Cliente cliente);
    boolean loginCliente(String email, String senha);
    Cliente buscarCliente(Integer id);
    void deletarCliente(Integer id);
    void atualizarCliente(Cliente cliente);
    List<Cliente> listarTodos();
}
