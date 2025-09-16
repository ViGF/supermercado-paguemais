package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
}
