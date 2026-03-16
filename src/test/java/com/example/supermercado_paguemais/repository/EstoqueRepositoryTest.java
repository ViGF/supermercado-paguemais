package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Estoque;
import com.example.supermercado_paguemais.model.Produto;
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

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class EstoqueRepositoryTest {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Test
    @DisplayName("Retorna produto, caso exista")
    void findByProdutoIdProduto() {

        Produto produto = new Produto("Geleia", new BigDecimal(13.99), "Mercearia", 30);
        produto = produtoRepository.save(produto);


        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque = estoqueRepository.save(estoque);


        Optional<Estoque> result = estoqueRepository.findByProdutoIdProduto(produto.getIdProduto());

        assertThat(result).isPresent();
        assertThat(result.get().getProduto().getIdProduto()).isEqualTo(produto.getIdProduto());
    }

    @Test
    @DisplayName("Quando não existe retorna vazio")
    void findByProdutoIdProduto_ReturnEmpty() {

        Produto produto = new Produto("Arroz", new BigDecimal(25.00), "Mercearia", 50);
        produto = produtoRepository.save(produto);

        Optional<Estoque> result = estoqueRepository.findByProdutoIdProduto(produto.getIdProduto());

        assertThat(result).isEmpty();
    }
}