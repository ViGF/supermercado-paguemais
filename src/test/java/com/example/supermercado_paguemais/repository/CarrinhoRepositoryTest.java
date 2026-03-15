package com.example.supermercado_paguemais.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class CarrinhoRepositoryTest {

    @Test
    void findByCliente() {
    }

    @Test
    void deleteByCliente() {
    }
}