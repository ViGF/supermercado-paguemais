package models;

public class MeioPagamento {
    private int idMeioPagamento;
    private int idCliente;//poderia ser Tipo, falta terminar
    
    public class MeioPagamento (int idMeioPagamento, Cliente cliente){
    this.idMeioPagamento = idMeioPagamento;
    this.cliente = cliente;
    }
}
