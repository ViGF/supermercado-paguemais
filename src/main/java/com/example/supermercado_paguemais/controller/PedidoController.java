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

    @PostMapping
    public ResponseEntity<Pedido> realizarCompra(
            @RequestParam Integer idCliente,
            @RequestParam Integer idMeioPagamento
    ) {
        Pedido pedido = pedidoService.realizarCompra(idCliente, idMeioPagamento);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Pedido>> listarPedidosPorCliente(@PathVariable Integer idCliente) {
        List<Pedido> pedidos = pedidoService.listarPedidosPorCliente(idCliente);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer idPedido) {
        Pedido pedido = pedidoService.buscarPorId(idPedido);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }
}
