package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
}
