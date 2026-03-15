package com.example.supermercado_paguemais.repository;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProdutoRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Test
    void findByNomeProdutoContainingIgnoreCase() {

    }

    @Test
    void findByCategoriaIgnoreCase() {

    }
}