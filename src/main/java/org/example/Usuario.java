package org.example;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Usuario {

    private UUID id;
    private String nome;
    private String email;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private TipoDeUsuario tipoDeUsuario;
    private int idade;
    private final List<Livro> livros  = new ArrayList<>();

    public Usuario(String nome, String email, TipoDeUsuario tipoDeUsuario, int idade) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.tipoDeUsuario = tipoDeUsuario;
        this.idade = idade;

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

        return List.copyOf(livros);
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

   public void emprestarLivro(Livro livro){
        livros.add(livro);
   }

   public void devolverLivro(Livro livro){
        livros.remove(livro);
   }
}
