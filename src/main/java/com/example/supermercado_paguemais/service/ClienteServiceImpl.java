package com.example.supermercado_paguemais.service;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Endereco;
import com.example.supermercado_paguemais.model.UsuarioRole;
import com.example.supermercado_paguemais.repository.CarrinhoRepository;
import com.example.supermercado_paguemais.repository.ClienteRepository;
import com.example.supermercado_paguemais.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final CarrinhoRepository carrinhoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, CarrinhoRepository carrinhoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.carrinhoRepository = carrinhoRepository;
    }

    @Override
    @Transactional
    public void cadastrarCliente(Cliente cliente) {

        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        cliente.setRole(UsuarioRole.USER);

        Carrinho carrinho = new Carrinho();
        carrinho.setQuantidadeItens(0);
        carrinho.setCliente(cliente);

        cliente.setCarrinho(carrinho);

        clienteRepository.save(cliente);
    }

    @Override
    public boolean login(String email, String senha) {
        return clienteRepository.findByEmail(email)
                .map(cliente -> passwordEncoder.matches(senha, cliente.getSenha()))
                .orElse(false);
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