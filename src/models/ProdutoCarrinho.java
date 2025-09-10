package models;

public class ProdutoCarrinho {
    private Produto produto;
    private int unidades;

    public double calcularPreco() {
        return produto.getPreco() * unidades;
    }

    public void atualizarQtd(int extra) {
        this.unidades += extra;
    }

    public ProdutoCarrinho() {
    }

    public ProdutoCarrinho(Produto produto, int unidades) {
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
