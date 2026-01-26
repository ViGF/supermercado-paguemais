package com.example.supermercado_paguemais.controller;

import com.example.supermercado_paguemais.model.Pedido;
import com.example.supermercado_paguemais.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/realizar-compra/{idCliente}")
    public ResponseEntity<?> criarPedido(@PathVariable Integer idCliente) {
        try {
            Pedido pedido = pedidoService.realizarCompra(idCliente);
            return ResponseEntity.ok(pedido);
        } catch (RuntimeException e) {
            return ResponseEntity.ok("Aviso: " + e.getMessage());
        }
    }

    @PutMapping("/confirmar/{idPedido}")
    public ResponseEntity<?> confirmarPedido(@PathVariable Integer idPedido, @RequestBody Pedido dadosPagamento) {
        try {
            Pedido pedidoConfirmado = pedidoService.confirmarPedido(idPedido, dadosPagamento);
            return ResponseEntity.ok(pedidoConfirmado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer idPedido) {
        return pedidoService.buscarPorId(idPedido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Integer id, @RequestBody Pedido pedidoAtualizado) {
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoAtualizado);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Integer id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
