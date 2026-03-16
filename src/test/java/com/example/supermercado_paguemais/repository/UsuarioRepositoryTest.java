package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Administrador;
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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get Client sucessfully from DB")
    @Transactional
    void findByEmailCase1() {
        String email = "usuario-teste@gmail.com";
        Cliente clienteTeste = new Cliente();
        clienteTeste.setNomeCliente("Cliente de Teste");
        clienteTeste.setEmail(email);
        clienteTeste.setSenha("segredo");
        BigDecimal saldo = new BigDecimal(10);
        clienteTeste.setSaldoConta(saldo);
        this.createUsuario(clienteTeste);

        Optional<Usuario> result = this.usuarioRepository.findByEmail(email);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should get Admin sucessfully from DB")
    @Transactional
    void findByEmailCase2() {
        String email = "adm-teste@gmail.com";
        Administrador admTeste = new Administrador();
        admTeste.setEmail(email);
        admTeste.setSenha("segredo");
        this.createUsuario(admTeste);

        Optional<Usuario> result = this.usuarioRepository.findByEmail(email);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get User from DB when User not exists")
    void findByEmailCase3() {
        String email = "usuario-teste@gmail.com";

        Optional<Usuario> result = this.usuarioRepository.findByEmail(email);

        assertThat(result.isEmpty()).isTrue();
    }

    private Usuario createUsuario(Usuario usuario){
        Usuario newUsuario = usuario;
        this.entityManager.persist(usuario);
        return newUsuario;
    }
}