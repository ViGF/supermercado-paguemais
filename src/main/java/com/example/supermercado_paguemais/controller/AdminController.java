package com.example.supermercado_paguemais.controller;

import com.example.supermercado_paguemais.model.Pedido;
import com.example.supermercado_paguemais.service.ClienteService;
import com.example.supermercado_paguemais.service.PedidoService;
import com.example.supermercado_paguemais.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> listarTodosPedidos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @PatchMapping("/produtos/{id}/estoque")
    public ResponseEntity<Void> atualizarEstoque(@PathVariable Integer id, @RequestBody Integer quantidade) {
        produtoService.atualizarEstoque(id, quantidade);
        return ResponseEntity.noContent().build();
    }

    //terminar de colocar todos os endpoints
}
