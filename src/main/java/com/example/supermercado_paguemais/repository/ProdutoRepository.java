package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
