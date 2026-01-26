package com.example.supermercado_paguemais.DTO;

public record ConfirmacaoPagamentoDTO(
        String numeroCartao,
        String nomeTitular,
        String validade,
        String cvv
) {}