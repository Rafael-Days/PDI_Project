package br.com.biblioteca.menu;

import br.com.biblioteca.service.Biblioteca;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private final Biblioteca biblioteca;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.biblioteca = new Biblioteca();
    }

    public void iniciar() {
        int opcao;

        do {
            mostrarOpcoes();
            opcao = lerNumero();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    emprestarLivro();
                    break;
                case 4:
                    devolverLivro();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void mostrarOpcoes() {
        System.out.println("\n====================");
        System.out.println("->SISTEMA BIBLIOTECA");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Emprestar livro");
        System.out.println("4 - Devolver livro");
        System.out.println("0 - Sair");
        System.out.print("Selecione uma opção: ");
    }

    private int lerNumero() {
        while (!scanner.hasNextInt()) {
            System.out.println("Digite apenas números!");
            scanner.next();
        }

        int numero = scanner.nextInt();
        scanner.nextLine();

        return numero;
    }

    private void cadastrarLivro() {
        System.out.println("\n--- CADASTRAR LIVRO ---");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        int idLivro = biblioteca.cadastrarLivro(titulo, autor).getIdLivro();

        System.out.println("\nLivro cadastrado com sucesso!");
        System.out.println("ID do livro: " + idLivro);
    }

    private void listarLivros() {
        System.out.println("\n>>>>> LIVROS CADASTRADOS <<<<<");
        biblioteca.listarLivros();
    }

    private void emprestarLivro() {
        System.out.println("\n>>>>> EMPRESTAR LIVRO <<<<<");

        System.out.print("Digite o ID do livro: ");
        int idLivro = lerNumero();

        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("CPF do usuário: ");
        String cpf = scanner.nextLine();

        boolean emprestado = biblioteca.emprestarLivro(
                idLivro,
                nome,
                cpf
        );

        if (emprestado) {
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println(
                    "Não foi possível realizar o empréstimo. " +
                            "Verifique se o livro existe ou está disponível."
            );
        }
    }

    private void devolverLivro() {
        System.out.println("\n--- DEVOLVER LIVRO ---");

        System.out.print("Digite o ID do livro: ");
        int idLivro = lerNumero();

        boolean devolvido = biblioteca.devolverLivro(idLivro);

        if (devolvido) {
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println(
                    "Não foi possível devolver o livro. " +
                            "Verifique o ID informado."
            );
        }
    }
}