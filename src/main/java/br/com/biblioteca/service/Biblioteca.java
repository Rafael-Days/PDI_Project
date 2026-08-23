package br.com.biblioteca.service;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.model.UsuarioComum;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    @Getter //Retorna a lista de livros
    private final List<Livro> livros;
    private final List<Usuario> usuarios;
    private final List<Emprestimo> emprestimos;

    private int proximoIdLivro;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();

        this.proximoIdLivro = 1;

        cadastrarLivrosIniciais();
    }

    private void cadastrarLivrosIniciais() {
        cadastrarLivro("Mistbonr", "Brandon Sanderson");
        cadastrarLivro("Conjurador", "Taran Matharu");
        cadastrarLivro("O Senhor dos Anéis", "J.R.R. Tolkien");
    }

    public Livro cadastrarLivro(String titulo, String autor) {
        Livro livro = new Livro(proximoIdLivro, titulo, autor);

        livros.add(livro);
        proximoIdLivro++;

        return livro;
    }

    public Livro buscarLivroPorId(int idLivro) {
        for (Livro livro : livros) {
            if (livro.getIdLivro() == idLivro) {
                return livro;
            }
        }

        return null;
    }

    public Usuario cadastrarUsuario(String nome, String cpf) {
        Usuario usuario = buscarUsuarioPorCpf(cpf);

        if (usuario != null) {
            return usuario;
        }

        Usuario novoUsuario = new UsuarioComum(nome, cpf);
        usuarios.add(novoUsuario);

        return novoUsuario;
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        return null;
    }

    public boolean emprestarLivro(int idLivro, String nomeUsuario, String cpf) {
        Livro livro = buscarLivroPorId(idLivro);

        if (livro == null || !livro.isDisponivel()) {
            return false;
        }

        Usuario usuario = cadastrarUsuario(nomeUsuario, cpf);

        Emprestimo emprestimo = new Emprestimo(livro, usuario);

        emprestimos.add(emprestimo);
        livro.emprestar();

        return true;
    }

    public boolean devolverLivro(int idLivro) {
        Emprestimo emprestimo = buscarEmprestimoAtivoPorLivro(idLivro);

        if (emprestimo == null) {
            return false;
        }

        emprestimo.finalizar();
        emprestimo.getLivro().devolver();

        return true;
    }

    private Emprestimo buscarEmprestimoAtivoPorLivro(int idLivro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtivo()
                    && emprestimo.getLivro().getIdLivro() == idLivro) {

                return emprestimo;
            }
        }

        return null;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}