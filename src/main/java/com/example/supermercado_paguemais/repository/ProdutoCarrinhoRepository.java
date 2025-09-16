package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Integer> {
}
