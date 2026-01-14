package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Endereco;
import com.example.supermercado_paguemais.repository.CarrinhoRepository;
import com.example.supermercado_paguemais.repository.ClienteRepository;
import com.example.supermercado_paguemais.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final CarrinhoRepository carrinhoRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, CarrinhoRepository carrinhoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.carrinhoRepository = carrinhoRepository;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public boolean login(String email, String senha) {
        return clienteRepository
                .findByEmailAndSenha(email.trim(), senha.trim())
                .isPresent();
    }

    @Override
    @Transactional
    public void deletarCliente(Integer id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        carrinhoRepository.deleteByCliente(cliente);

        clienteRepository.delete(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional
    public Cliente atualizarEndereco(Integer idCliente, Endereco enderecoNovo) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Endereco enderecoAtual = cliente.getIdEndereco();

        enderecoAtual.setRua(enderecoNovo.getRua());
        enderecoAtual.setNumero(enderecoNovo.getNumero());
        enderecoAtual.setCidade(enderecoNovo.getCidade());
        enderecoAtual.setCep(enderecoNovo.getCep());
        enderecoAtual.setBairro(enderecoNovo.getBairro());

        enderecoRepository.save(enderecoAtual);

        return cliente;
    }
}
