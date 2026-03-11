package com.example.supermercado_paguemais.repository;


import com.example.supermercado_paguemais.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository  extends JpaRepository<Administrador, Long> {
}
