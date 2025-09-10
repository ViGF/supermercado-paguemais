package models;

public class Estoque {
    private int idEstoque;
    private Produto produto;
    private int quantidade;

    public void addUnidade(int qtd) {
        this.quantidade += qtd;
    }

    public boolean removerUnidade(int qtd) {
        if (quantidade <=  qtd) {
            this.quantidade -= qtd;
            return true;
        }
        return false;
    }

    public Estoque() {
    }

    public Estoque(int idEstoque, Produto produto, int quantidade) {
        this.idEstoque = idEstoque;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return produto.getNomeProduto() + " | Estoque: " + quantidade;
    }
}
