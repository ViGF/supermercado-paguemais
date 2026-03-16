package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Test
    @DisplayName("Deve retornar o produto de nome especificado, se existir")
    void findByNomeProdutoContainingIgnoreCase() {
        String nome2 = "Geleia";
        Produto data = new Produto("Geleia", new BigDecimal(13.99), "Mercearia", 30);
        this.produtoRepository.save(data);

        List<Produto> produtoEncontrado = this.produtoRepository.findByNomeProdutoContainingIgnoreCase(nome2);
        assertThat(produtoEncontrado.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("Deve retornar lista vazia")
    void findByNomeReturnEmptyList() {
        List<Produto> resultado = produtoRepository.findByNomeProdutoContainingIgnoreCase("NomeInexistente");
        assertThat(resultado).isEmpty();
    }

    @Test
    @DisplayName("Deve retornar os produtos de determinada categoria, caso existam")
    void findByCategoriaIgnoreCase() {
        String categoria = "Mercearia";
        Produto data = new Produto("Geleia", new BigDecimal(13.99), categoria, 30);
        this.produtoRepository.save(data);

        List<Produto> produtosEncontrados = this.produtoRepository.findByCategoriaIgnoreCase(categoria);
        assertThat(produtosEncontrados.isEmpty()).isFalse();
    }




}