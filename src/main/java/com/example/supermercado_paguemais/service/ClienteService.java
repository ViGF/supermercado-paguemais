package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cartao;
import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Endereco;

import java.util.List;

public interface ClienteService {
    void cadastrarCliente(Cliente cliente);
    boolean login(String email, String senha);
    void deletarCliente(Integer id);
    List<Cliente> listarTodos();
    Cliente adicionarEndereco(Integer idCliente, Endereco endereco);
    void removerEndereco(Integer idCliente,Integer idEndereco);
    List<Endereco> listarEnderecos(Integer idCliente);
    Cliente adicionarCartao(Integer idCliente, Cartao cartao);
    void removerCartao(Integer idCliente, Integer idCartao);
    List<Cartao> listarCartao(Integer idCliente);
}
