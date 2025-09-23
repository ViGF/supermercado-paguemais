package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
    Optional<Carrinho> findByIdClienteAndIdProduto(Integer idCliente, Integer idProduto);

    List<Carrinho> findByIdCliente(Integer idCliente);
}
