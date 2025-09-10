package models;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private double preco;
    private String categoria;

    public void atualizarProduto(String nome, double preco, String categoria) {
        this.nomeProduto = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public boolean validarPreco() {
        return preco > 0;
    }

    public Produto() {
    }

    public Produto(int idProduto, String nomeProduto, double preco, String categoria) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
