package controllers;

public interface ClienteController {
  public boolean fazerCadastro(String nome, String email, String senha);
  public boolean fazerLogin(String email, String senha);
}
