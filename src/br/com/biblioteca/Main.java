package br.com.biblioteca;

public class Main {

    public static void main(String[] args) {

        Livro livro = new Livro(
                "O Senhor dos Anéis",
                "Tolkien",
                "978-0544003415"
        );

        UsuarioComum usuario = new UsuarioComum(
                "Rafael",
                "12345678900"
        );

        System.out.println("livro: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Usuário: " + usuario.getNome());

        System.out.println(
                "Disponível: " + livro.isDisponivel()
        );

        Emprestimo emprestimo = new Emprestimo(
                livro,
                usuario
        );

        System.out.println("\n--- Empréstimo realizado ---");

        System.out.println(
                "Livro: " + emprestimo.getLivro().getTitulo()
        );

        System.out.println(
                "Usuário: " + emprestimo.getUsuario().getNome()
        );

        System.out.println(
                "Data: " + emprestimo.getDataEmprestimo()
        );

        System.out.println(
                "Disponível: " + livro.isDisponivel()
        );

        emprestimo.devolver();

        System.out.println("\n--- Livro devolvido ---");

        System.out.println(
                "Disponível: " + livro.isDisponivel()
        );
    }
}