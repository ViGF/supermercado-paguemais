package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByEmailAndSenha(String email, String senha);
}
