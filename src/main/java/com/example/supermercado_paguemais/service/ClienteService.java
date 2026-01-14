package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Endereco;

import java.util.List;

public interface ClienteService {
    void cadastrarCliente(Cliente cliente);
    boolean login(String email, String senha);
    void deletarCliente(Integer id);
    List<Cliente> listarClientes();
    Cliente atualizarEndereco(Integer idCliente, Endereco enderecoNovo);
}
