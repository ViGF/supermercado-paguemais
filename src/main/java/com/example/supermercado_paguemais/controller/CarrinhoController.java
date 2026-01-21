package com.example.supermercado_paguemais.controller;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.service.CarrinhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Carrinho> adicionarProduto(
            @RequestParam Integer idCliente,
            @RequestParam Integer idProduto,
            @RequestParam Integer quantidade) {
        Carrinho carrinho = carrinhoService.adicionarProduto(idCliente, idProduto, quantidade);
        return ResponseEntity.status(201).body(carrinho);
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Void> removerProduto(
            @RequestParam Integer idCliente,
            @RequestParam Integer idProduto) {
        carrinhoService.removerProduto(idCliente, idProduto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Carrinho> atualizarQuantidade(
            @RequestParam Integer idCliente,
            @RequestParam Integer idProduto,
            @RequestParam Integer novaQuantidade) {
        Carrinho atualizado = carrinhoService.atualizarQuantidade(idCliente, idProduto, novaQuantidade);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Carrinho> listarCarrinho(@PathVariable Integer idCliente) {
        Carrinho carrinho = carrinhoService.listarCarrinho(idCliente);
        return ResponseEntity.ok(carrinho);
    }

    @DeleteMapping("/limpar/{idCliente}")
    public ResponseEntity<Void> limparCarrinho(@PathVariable Integer idCliente) {
        carrinhoService.limparCarrinho(idCliente);
        return ResponseEntity.noContent().build();
    }
}
