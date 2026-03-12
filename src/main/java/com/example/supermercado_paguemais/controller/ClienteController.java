package com.example.supermercado_paguemais.controller;

import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Pedido;
import com.example.supermercado_paguemais.model.Usuario;
import com.example.supermercado_paguemais.service.CarrinhoService;
import com.example.supermercado_paguemais.service.ClienteService;
import com.example.supermercado_paguemais.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PostMapping("finalizar-compra")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<Pedido> realizarCompra(@AuthenticationPrincipal Usuario usuarioLogado) {
//        return ResponseEntity.ok(pedidoService.realizarCompra(usuarioLogado.getId()));
//    }

}
