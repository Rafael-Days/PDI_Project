package br.com.biblioteca.model;

import lombok.Getter;

@Getter
public class Usuario {

    private final String nome;
    private final String cpf;

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

}