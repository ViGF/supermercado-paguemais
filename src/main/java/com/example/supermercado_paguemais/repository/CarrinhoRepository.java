package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
}
