package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Long idCliente;
    private String nome;
    private String email;
    private String senha;
    private Endereco idEndereco;
    private List<Cartao> cartoes;
    private double saldoConta;
    private List<Carrinho> carrinho;
    private List<Pedido> pedidos;
    private List<MeioPagamento> meiosPagamento;

    public boolean validarEmail() {
        return email != null && email.contains("@");
    }

    public boolean autenticar(String senhaDigitada) {
        return senha != null && senha.equals(senhaDigitada);
    }

    public Cliente() {
        this.cartoes = new ArrayList<>();
        this.carrinho = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.meiosPagamento = new ArrayList<>();
        this.saldoConta = 0;
    }

    public Cliente(Long idCliente, String nome, String email, String senha, Endereco idEndereco, List<Cartao> cartoes, double saldoConta, List<Carrinho> carrinho, List<Pedido> pedidos, List<MeioPagamento> meiosPagamento) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idEndereco = idEndereco;
        this.cartoes = new ArrayList<>();
        this.saldoConta = saldoConta;
        this.carrinho = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.meiosPagamento = new ArrayList<>();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public List<Carrinho> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Carrinho> carrinho) {
        this.carrinho = carrinho;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<MeioPagamento> getMeiosPagamento() {
        return meiosPagamento;
    }

    public void setMeiosPagamento(List<MeioPagamento> meiosPagamento) {
        this.meiosPagamento = meiosPagamento;
    }
}
