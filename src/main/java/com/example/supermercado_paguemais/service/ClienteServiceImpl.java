package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Cartao;
import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Endereco;
import com.example.supermercado_paguemais.repository.CartaoRepository;
import com.example.supermercado_paguemais.repository.ClienteRepository;
import com.example.supermercado_paguemais.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final CartaoRepository cartaoRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, CartaoRepository cartaoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public boolean login(String email, String senha) {
        return clienteRepository.findByEmailAndSenha(email, senha).isPresent();
    }

    @Override
    public void deletarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente adicionarEndereco(Integer idCliente, Endereco endereco) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        cliente.setIdEndereco(enderecoSalvo.getIdEndereco());

        return clienteRepository.save(cliente);
    }

    @Override
    public void removerEndereco(Integer idCliente, Integer idEndereco) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if(!cliente.getIdEndereco().equals(idEndereco)) {
            throw new RuntimeException("Endereco não pertence ao cliente informado");
        }

        cliente.setIdEndereco(null);
        clienteRepository.save(cliente);
        enderecoRepository.deleteById(idEndereco);

    }

    @Override
    public Cliente adicionarCartao(Integer idCliente, Cartao cartao) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setInfoCartao(cartao.getNumeroCartao());

        return clienteRepository.save(cliente);
    }

    @Override
    public void removerCartao(Integer idCliente, Integer idCartao) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if(!cliente.getInfoCartao().equals(idCartao.toString())) {
            throw new RuntimeException("Cartão não pertence ao cliente informado");
        }

        cliente.setInfoCartao(null);
        clienteRepository.save(cliente);

        cartaoRepository.deleteById(idCartao);
    }

    @Override
    public List<Cartao> listarCartao(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return cartaoRepository.findByNumeroCartao(cliente.getInfoCartao()).map(List::of).orElse(List.of());
    }
}
