package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByNomeProdutoContainingIgnoreCase(String nomeProduto);
    List<Produto> findByCategoriaIgnoreCase(String categoria);
}
