package services;

import models.Carrinho;
import models.Pedido;
import models.MeioPagamento;

public interface PedidoService {
    Pedido criarPedido(Carrinho carrinho, MeioPagamento pagamento);
    Pedido buscarPorId(int id);
    void atualizarStatus(int idPedido, String novoStatus);
}
