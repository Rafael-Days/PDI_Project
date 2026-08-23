package br.com.biblioteca.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Emprestimo {

    private final Livro livro;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;
    }

    public void finalizar() {
        if (ativo) {
            this.dataDevolucao = LocalDate.now();
            this.ativo = false;
        }
    }

}