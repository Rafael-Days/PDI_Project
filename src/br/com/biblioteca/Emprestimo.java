package br.com.biblioteca;

import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, Usuario usuario) {

        if (!livro.isDisponivel()) {
            throw new IllegalArgumentException("Livro não está disponível.");
        }

        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();

        livro.emprestar();
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void devolver() {
        livro.devolver();
    }
}