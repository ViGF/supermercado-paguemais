package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cartao;
import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Endereco;
import com.example.supermercado_paguemais.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {

    }

    @Override
    public boolean login(String email, String senha) {
        return false;
    }

    @Override
    public void deletarCliente(Integer id) {

    }

    @Override
    public List<Cliente> listarClientes() {
        return List.of();
    }

    @Override
    public Cliente adicionarEndereco(Integer idCliente, Endereco endereco) {
        return null;
    }

    @Override
    public void removerEndereco(Integer idCliente, Integer idEndereco) {

    }

    @Override
    public Cliente adicionarCartao(Integer idCliente, Cartao cartao) {
        return null;
    }

    @Override
    public void removerCartao(Integer idCliente, Integer idCartao) {

    }

    @Override
    public List<Cartao> listarCartao(Integer idCliente) {
        return List.of();
    }
}
