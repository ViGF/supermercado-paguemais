package com.example.supermercado_paguemais.repository;

import com.example.supermercado_paguemais.model.Carrinho;
import com.example.supermercado_paguemais.model.Cliente;
import com.example.supermercado_paguemais.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
    @Query("SELECT c FROM Carrinho c JOIN c.produtosCarrinho pc WHERE c.cliente = :cliente AND pc.produto = :produto")
    Optional<Carrinho> findByClienteAndProduto(@Param("cliente") Cliente cliente, @Param("produto") Produto produto);

    Optional<Carrinho> findByCliente(Cliente cliente);

    List<Carrinho> findAllByCliente(Cliente cliente);
}
