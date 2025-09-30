package com.example.supermercado_paguemais.controller;

import com.example.supermercado_paguemais.model.Cartao;
import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Endereco;
import com.example.supermercado_paguemais.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Cadastro de cliente
    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarCliente(@RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(201).build();
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String senha) {
        boolean autenticado = clienteService.login(email, senha);
        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

    // Deletar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    // Listar clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    // Adicionar endereço
    @PostMapping("/{idCliente}/endereco")
    public ResponseEntity<Cliente> adicionarEndereco(@PathVariable Integer idCliente, @RequestBody Endereco endereco) {
        Cliente cliente = clienteService.adicionarEndereco(idCliente, endereco);
        return ResponseEntity.ok(cliente);
    }

    // Remover endereço
    @DeleteMapping("/{idCliente}/endereco/{idEndereco}")
    public ResponseEntity<Void> removerEndereco(@PathVariable Integer idCliente, @PathVariable Integer idEndereco) {
        clienteService.removerEndereco(idCliente, idEndereco);
        return ResponseEntity.noContent().build();
    }

    // Adicionar cartão
    @PostMapping("/{idCliente}/cartao")
    public ResponseEntity<Cliente> adicionarCartao(@PathVariable Integer idCliente, @RequestBody Cartao cartao) {
        Cliente cliente = clienteService.adicionarCartao(idCliente, cartao);
        return ResponseEntity.ok(cliente);
    }

    // Remover cartão
    @DeleteMapping("/{idCliente}/cartao/{idCartao}")
    public ResponseEntity<Void> removerCartao(@PathVariable Integer idCliente, @PathVariable Integer idCartao) {
        clienteService.removerCartao(idCliente, idCartao);
        return ResponseEntity.noContent().build();
    }

    // Listar cartões do cliente
    @GetMapping("/{idCliente}/cartoes")
    public ResponseEntity<List<Cartao>> listarCartao(@PathVariable Integer idCliente) {
        return ResponseEntity.ok(clienteService.listarCartao(idCliente));
    }
}
