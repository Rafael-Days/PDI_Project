package br.com.biblioteca.model;

import lombok.Getter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
public class Emprestimo {

    private static final int PRAZO_EMPRESTIMO_DIAS = 7;
    private static final double VALOR_MULTA_POR_DIA = 2.00;

    private final Livro livro;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private double multa;
    private boolean ativo;

    public Emprestimo(Livro livro, Usuario usuario) {
        this(livro, usuario, LocalDate.now());
    }

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.multa = 0.0;
        this.ativo = true;
    }

    public void finalizar() {
        if (ativo) {
            this.dataDevolucao = LocalDate.now();
            this.multa = calcularMulta();
            this.ativo = false;
        }
    }

    private double calcularMulta() {
        long diasEmprestado = ChronoUnit.DAYS.between(
                dataEmprestimo,
                dataDevolucao
        );

        long diasAtraso = Math.max(
                0,
                diasEmprestado - PRAZO_EMPRESTIMO_DIAS
        );

        return diasAtraso * VALOR_MULTA_POR_DIA;
    }

}