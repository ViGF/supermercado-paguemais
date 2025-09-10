package models;

import java.util.Date;

public class Cartao {
    private int idCartao;
    private String bandeira;
    private String nomeTitular;
    private String numeroCartao;
    private Date validade;

    public boolean validarNumero() {
        return numeroCartao != null && numeroCartao.replaceAll("\\D", "").length() == 16;
    }

    public String mascararNumero() {
        if(numeroCartao == null || numeroCartao.length() < 4) return "****";
        return "**** **** **** " + numeroCartao.substring(numeroCartao.length() - 4);
    }

    public Cartao() {
    }

    public Cartao(int idCartao, String bandeira, String nomeTitular, String numeroCartao, Date validade) {
        this.idCartao = idCartao;
        this.bandeira = bandeira;
        this.nomeTitular = nomeTitular;
        this.numeroCartao = numeroCartao;
        this.validade = validade;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}
