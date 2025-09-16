package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
