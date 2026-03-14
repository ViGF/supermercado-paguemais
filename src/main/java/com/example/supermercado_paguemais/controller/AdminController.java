package com.example.supermercado_paguemais.controller;

import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Estoque;
import com.example.supermercado_paguemais.model.Pedido;
import com.example.supermercado_paguemais.model.Produto;
import com.example.supermercado_paguemais.service.ClienteService;
import com.example.supermercado_paguemais.service.PedidoService;
import com.example.supermercado_paguemais.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/pedidos/listar")
    public ResponseEntity<List<Pedido>> listarTodosPedidos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @PutMapping("/produtos/estoque")
    public ResponseEntity<Produto> atualizarEstoque(
            @RequestParam Integer id,
            @RequestParam Integer quantidade
    ) {
        try {
            Produto atualizado = produtoService.atualizarEstoque(id, quantidade);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/produtos/estoque/{id}")
    public ResponseEntity<Estoque> buscarEstoque(@PathVariable Integer id) {
        Optional<Estoque> estoque = produtoService.buscarEstoquePorProduto(id);
        return estoque.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/pedido/buscar/{idPedido}")
    public ResponseEntity<Pedido> buscarPorPedido(@PathVariable Integer idPedido) {
        return pedidoService.buscarPorId(idPedido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/produtos/buscar/{id}")
    public ResponseEntity<Produto> buscarPorProduto(@PathVariable Integer id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/produtos/listar")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/produtos/buscar/{nome}")
    public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoService.buscarPorNome(nome));
    }

    @GetMapping("/produto/buscar/{categoria}")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(produtoService.buscarPorCategoria(categoria));
    }

}
