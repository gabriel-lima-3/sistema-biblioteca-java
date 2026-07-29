package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Usuario {

    private UUID id;
    private String nome;
    private String email;
    private TipoDeUsuario tipoDeUsuario;
    private int idade;
    private List<Livro> livros;

    public Usuario() {
    }

    public Usuario(String nome, String email, TipoDeUsuario tipoDeUsuario, int idade) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.tipoDeUsuario = tipoDeUsuario;
        this.idade = idade;
        this.livros = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idade == usuario.idade && Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && tipoDeUsuario == usuario.tipoDeUsuario && Objects.equals(livros, usuario.livros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, tipoDeUsuario, idade, livros);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipoDeUsuario=" + tipoDeUsuario +
                ", idade=" + idade +
                ", livros=" + livros +
                '}';
    }
}
