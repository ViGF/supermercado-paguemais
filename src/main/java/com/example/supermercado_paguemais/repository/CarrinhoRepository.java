package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
    Optional<Carrinho> findByCliente(Cliente cliente);

    void deleteByCliente(Cliente cliente);
}
