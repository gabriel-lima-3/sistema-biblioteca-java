package org.example;
import java.util.Objects;
import java.util.UUID;

public class Livro {

    private final UUID id = UUID.randomUUID();
    private String titulo;
    private int ano;
    private String autor;
    private Genero genero;
    private Status status;

    public Livro(String titulo, int ano, String autor, Genero genero) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.genero = genero;
        this.status = Status.DISPONIVEL;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", autor='" + autor + '\'' +
                ", genero=" + genero +
                ", status=" + status +
                '}';
    }


}



