package br.com.biblioteca;

public class UsuarioComum extends Usuario {

    private int limiteEmprestimos;

    public UsuarioComum(String nome, String cpf) {
        super(nome, cpf);
        this.limiteEmprestimos = 3;
    }

    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }
}