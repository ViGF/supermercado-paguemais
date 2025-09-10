package models;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private int idCarrinho;
    private Cliente Cliente;
    private List<ProdutoCarrinho> itens;
    private double valorTotal;

    public void addItemCarrinho(ProdutoCarrinho produto) {
        itens.add(produto);
        valorTotal += produto.calcularPreco();
    }

    public void removerItemCarrinho(ProdutoCarrinho produto) {
        if(itens.remove(produto)) {
            valorTotal -= produto.calcularPreco();
        }
    }

    public void limparCarrinho() {
        itens.clear();
        valorTotal = 0;
    }

    public double calcularTotal() {
        valorTotal = 0;
        for (ProdutoCarrinho item : itens) {
            valorTotal += item.calcularPreco();
        }
        return valorTotal;
    }

    public Carrinho() {
        itens = new ArrayList<>();
        valorTotal = 0;
    }

    public Carrinho(int idCarrinho, models.Cliente cliente, List<ProdutoCarrinho> itens, double valorTotal) {
        this.idCarrinho = idCarrinho;
        Cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = valorTotal;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public models.Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(models.Cliente cliente) {
        Cliente = cliente;
    }

    public List<ProdutoCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ProdutoCarrinho> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
