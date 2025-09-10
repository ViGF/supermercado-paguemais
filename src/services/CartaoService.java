package services;

import models.Cartao;

public interface CartaoService {
    void cadastrarCartao(Cartao cartao);
    boolean validarCartao(Cartao cartao);
    void removerCartao(int idCartao);
}
