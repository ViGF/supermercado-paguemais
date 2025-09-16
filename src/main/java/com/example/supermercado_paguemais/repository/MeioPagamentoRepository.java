package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.MeioPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeioPagamentoRepository extends JpaRepository<MeioPagamento, Integer> {
}
