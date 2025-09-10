package models;

public class ProdutoPedido {
    private Produto produto;
    private int unidades;

    public double calcularPreco() {
        return produto.getPreco() * unidades;
    }

    public ProdutoPedido() {
    }

    public ProdutoPedido(Produto produto, int unidades) {
        this.produto = produto;
        this.unidades = unidades;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return produto.getNomeProduto() + " x" + unidades + " = R$" + calcularPreco();
    }
}
