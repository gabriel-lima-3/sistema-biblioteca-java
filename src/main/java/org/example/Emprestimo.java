package org.example;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Emprestimo {

    private final UUID id = UUID.randomUUID();
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

    public UUID getId() {
        return id;
    }

    public Status getStatus() {
        return status;
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

