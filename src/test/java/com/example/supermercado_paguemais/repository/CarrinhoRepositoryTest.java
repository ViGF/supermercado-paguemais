package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.model.Cliente;
import jakarta.persistence.EntityManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
class CarrinhoRepositoryTest {

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get Carrinho sucessfully from DB")
    @Transactional
    void findByClienteCase1() {
        Carrinho carrinho = new Carrinho();
        Cliente clienteTeste = new Cliente();
        carrinho.setCliente(clienteTeste);
        String email = "cliente-teste@gmail.com";

        clienteTeste.setNomeCliente("Cliente de Teste");
        clienteTeste.setEmail(email);
        clienteTeste.setSenha("segredo");
        BigDecimal saldo = new BigDecimal(10);
        clienteTeste.setSaldoConta(saldo);
        clienteTeste.setCarrinho(carrinho);

        this.createCliente(clienteTeste);

        Optional<Carrinho> result = this.carrinhoRepository.findByCliente(clienteTeste);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get Carrinho from DB when User do not exists")
    @Transactional
    void findByClienteCase2() {
        Cliente clienteTeste = new Cliente();
        String email = "cliente-teste@gmail.com";

        clienteTeste.setNomeCliente("Cliente de Teste");
        clienteTeste.setEmail(email);
        clienteTeste.setSenha("segredo");
        BigDecimal saldo = new BigDecimal(10);
        clienteTeste.setSaldoConta(saldo);

        this.createCliente(clienteTeste);

        Optional<Carrinho> result = this.carrinhoRepository.findByCliente(clienteTeste);

        assertThat(result.isEmpty()).isTrue();

    }

    @Test
    @DisplayName("Should delete Carrinho from Client")
    @Transactional
    void deleteByCliente() {
        Carrinho carrinho = new Carrinho();
        Cliente clienteTeste = new Cliente();
        carrinho.setCliente(clienteTeste);
        String email = "cliente-teste@gmail.com";

        clienteTeste.setNomeCliente("Cliente de Teste");
        clienteTeste.setEmail(email);
        clienteTeste.setSenha("segredo");
        BigDecimal saldo = new BigDecimal(10);
        clienteTeste.setSaldoConta(saldo);
        clienteTeste.setCarrinho(carrinho);

        this.createCliente(clienteTeste);

        clienteTeste.setCarrinho(null);

        this.carrinhoRepository.deleteByCliente(clienteTeste);

        entityManager.flush();
        entityManager.clear();

        Optional<Carrinho> result = this.carrinhoRepository.findByCliente(clienteTeste);

        assertThat(result).isEmpty();
    }

    private Cliente createCliente(Cliente cliente){
        Cliente newCliente = cliente;
        this.entityManager.persist(cliente);
        return  newCliente;
    }
}