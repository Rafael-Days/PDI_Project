package br.com.biblioteca.model;

import lombok.Getter;

@Getter
public class Livro {

    private final int idLivro;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(int idLivro, String titulo, String autor) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    @Override
    public String toString() {
        String status = disponivel ? "Disponível" : "Emprestado";

        return "\nID: " + idLivro +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor +
                "\nStatus: " + status;
    }
}