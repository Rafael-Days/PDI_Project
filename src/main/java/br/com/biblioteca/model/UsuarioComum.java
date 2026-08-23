package br.com.biblioteca.model;

public class UsuarioComum extends Usuario {

    private int limiteEmprestimos;

    public UsuarioComum(String nome, String cpf) {
        super(nome, cpf);
    }

    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }
}