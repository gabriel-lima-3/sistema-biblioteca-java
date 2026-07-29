package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private Status status;
    private LocalDateTime horario;
    private LocalDateTime dataDevolucao;


    public Emprestimo(Livro livro, Usuario usuario, LocalDateTime horario, LocalDateTime dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.horario = horario;
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(livro, that.livro) && Objects.equals(usuario, that.usuario) && status == that.status && Objects.equals(horario, that.horario) && Objects.equals(dataDevolucao, that.dataDevolucao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro, usuario, status, horario, dataDevolucao);
    }
}

