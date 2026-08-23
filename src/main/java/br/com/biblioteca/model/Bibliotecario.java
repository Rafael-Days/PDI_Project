package br.com.biblioteca.model;

import lombok.Getter;

@Getter
public class Bibliotecario extends Usuario {

    private final String matricula;

    public Bibliotecario(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

}