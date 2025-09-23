package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
    Optional<Cartao> findByNumeroCartao(String infoCartao);
}
