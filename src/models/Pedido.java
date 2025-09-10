package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List<ProdutoPedido> itensPedido;
    private MeioPagamento meioPagamento; // coloca Cartão como meio quando for corrigido
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private Endereco enderecoEntrega;
    private double valorTotal;
    private String status; //pode criar um Enum com: PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE E CANCELADO

    public void addItem(ProdutoPedido produto) {
        itensPedido.add(produto);
        valorTotal += produto.calcularPreco();
        this.atualizadoEm = LocalDateTime.now();
    }

    public double calcularTotal() {
        valorTotal = 0;
        for (ProdutoPedido item : itensPedido) {
            valorTotal += item.calcularPreco();
        }
        return valorTotal;
    }

//    public void atualizarStatus(StatusPedido novoStatus) {
//        this.status = novoStatus;
//        this.atualizadoEm = LocalDateTime.now();
//    }


    public Pedido() {
        this.itensPedido = new ArrayList<>();
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
        //this.status = Pendente;
        this.valorTotal = 0;
    }

    public Pedido(int idPedido, Cliente cliente, List<ProdutoPedido> itensPedido, MeioPagamento meioPagamento, LocalDateTime criadoEm, LocalDateTime atualizadoEm, Endereco enderecoEntrega, double valorTotal, String status) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.itensPedido = itensPedido;
        this.meioPagamento = meioPagamento;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.enderecoEntrega = enderecoEntrega;
        this.valorTotal = valorTotal;
        this.status = status; //atualizar caso use ENUM
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ProdutoPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido #" + idPedido + " | Cliente: " + cliente.getNome() +
                " | Total: R$" + valorTotal + " | Status: " + status +
                " | Criado em: " + criadoEm + " | Atualizado em: " + atualizadoEm;
    }
}
