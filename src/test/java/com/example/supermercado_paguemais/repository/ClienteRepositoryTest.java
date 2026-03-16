package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Usuario;
import com.example.supermercado_paguemais.service.ClienteService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get User sucessfully from DB")
    @Transactional
    void findByEmailCase1() {
        String email = "cliente-teste@gmail.com";
        Cliente clienteTeste = new Cliente();
        clienteTeste.setNomeCliente("Cliente de Teste");
        clienteTeste.setEmail(email);
        clienteTeste.setSenha("segredo");
        BigDecimal saldo = new BigDecimal(10);
        clienteTeste.setSaldoConta(saldo);
        this.createCliente(clienteTeste);

        Optional<Cliente> result = this.clienteRepository.findByEmail(email);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get User from DB when User do not exists")
    void findByEmailCase2() {
        String email = "cliente-teste@gmail.com";

        Optional<Cliente> result = this.clienteRepository.findByEmail(email);

        assertThat(result.isEmpty()).isTrue();
    }

    private Cliente createCliente(Cliente cliente){
        Cliente newCliente = cliente;
        this.entityManager.persist(cliente);
        return  newCliente;
    }
}