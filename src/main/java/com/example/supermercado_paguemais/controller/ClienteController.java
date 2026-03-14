package com.example.supermercado_paguemais.controller;

import com.example.supermercado_paguemais.model.*;
import com.example.supermercado_paguemais.service.CarrinhoService;
import com.example.supermercado_paguemais.service.ClienteService;
import com.example.supermercado_paguemais.service.PedidoService;
import com.example.supermercado_paguemais.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cliente/cadastrar")
    public ResponseEntity<Void> cadastrarCliente(@RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cliente/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String senha) {
        boolean autenticado = clienteService.login(email, senha);
        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

    @PostMapping("/pedido/realizar/{idCliente}")
    public ResponseEntity<?> realizarCompra(@PathVariable Integer idCliente) {
        try {
            Pedido pedido = pedidoService.realizarCompra(idCliente);
            return ResponseEntity.ok(pedido);
        } catch (RuntimeException e) {
            return ResponseEntity.ok("Aviso: " + e.getMessage());
        }
    }

    @DeleteMapping("/cliente/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cliente/endereco/{idCliente}")
    public Cliente atualizarEndereco(
            @PathVariable Integer idCliente,
            @RequestBody Endereco enderecoNovo
    ) {
        return clienteService.atualizarEndereco(idCliente, enderecoNovo);
    }

    @PutMapping("/pedido/confirmar/{idPedido}")
    public ResponseEntity<?> confirmarPedido(@PathVariable Integer idPedido, @RequestBody Pedido dadosPagamento) {
        try {
            Pedido pedidoConfirmado = pedidoService.confirmarPedido(idPedido, dadosPagamento);
            return ResponseEntity.ok(pedidoConfirmado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/pedido/atualizar/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Integer id, @RequestBody Pedido pedidoAtualizado) {
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoAtualizado);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/pedido/deletar/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Integer id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/carrinho/adicionar-produto")
    public ResponseEntity<Carrinho> adicionarProduto(
            @RequestParam Integer idCliente,
            @RequestParam Integer idProduto,
            @RequestParam Integer quantidade) {
        Carrinho carrinho = carrinhoService.adicionarProduto(idCliente, idProduto, quantidade);
        return ResponseEntity.status(201).body(carrinho);
    }

    @DeleteMapping("/carrinho/remover-produto")
    public ResponseEntity<Void> removerProduto(
            @RequestParam Integer idCliente,
            @RequestParam Integer idProduto) {
        carrinhoService.removerProduto(idCliente, idProduto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/carrinho/atualizar-quantidade")
    public ResponseEntity<Carrinho> atualizarQuantidade(
            @RequestParam Integer idCliente,
            @RequestParam Integer idProduto,
            @RequestParam Integer novaQuantidade) {
        Carrinho atualizado = carrinhoService.atualizarQuantidade(idCliente, idProduto, novaQuantidade);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/carrinho/listar/{idCliente}")
    public ResponseEntity<Carrinho> listarCarrinho(@PathVariable Integer idCliente) {
        Carrinho carrinho = carrinhoService.listarCarrinho(idCliente);
        return ResponseEntity.ok(carrinho);
    }

    @DeleteMapping("/carrinho/limpar/{idCliente}")
    public ResponseEntity<Void> limparCarrinho(@PathVariable Integer idCliente) {
        carrinhoService.limparCarrinho(idCliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/produtos/buscar/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/produtos/listar")
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/produtos/buscar/{nome}")
    public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoService.buscarPorNome(nome));
    }

    @GetMapping("/produtos/buscar/{categoria}")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(produtoService.buscarPorCategoria(categoria));
    }

}
