package controllers;

public interface CarrinhoController {
    public void addProduto(String idProduto, int unidades);
    public void removerItem(String IdItem);
    public String getDetalhes();
    public boolean fazerPedido();
}