package br.com.biblioteca;

public class Bibliotecario extends Usuario {

    private String matricula;

    public Bibliotecario(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}