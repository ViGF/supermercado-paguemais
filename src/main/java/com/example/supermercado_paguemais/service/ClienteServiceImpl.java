package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final CarrinhoRepository repository;


    public ClienteServiceImpl(CarrinhoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {

    }

    @Override
    public boolean loginCliente(String email, String senha) {
        return false;
    }

    @Override
    public Cliente buscarCliente(Integer id) {
        return null;
    }

    @Override
    public void deletarCliente(Integer id) {

    }

    @Override
    public void atualizarCliente(Cliente cliente) {

    }

    @Override
    public List<Cliente> listarTodos() {
        return List.of();
    }
}
