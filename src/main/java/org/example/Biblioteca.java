package org.example;
import org.example.exceptions.LivroIndisponivelException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {
    }

    public List<Livro> getLivros() {
        return List.copyOf(livros);
    }

    public List<Usuario> getUsuarios() {
        return List.copyOf(usuarios);
    }


    public void cadastrarLivro(Livro livro) {
        this.livros.add(livro);

    }

    public void cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }




    public Emprestimo fazerEmprestimo(Livro livro, Usuario usuario) {


        if (livro.getStatus() != Status.DISPONIVEL) {
            throw new LivroIndisponivelException("{livro: " + livro.getTitulo() + "} {Id: " + livro.getId() + "} esta indisponivel");
        }
        livro.setStatus(Status.INDISPONIVEL);
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime dataEntrega = agora.plusDays(7);
        usuario.emprestarLivro(livro);
        Emprestimo emprestimo = new Emprestimo(livro, usuario, agora, dataEntrega);
        this.emprestimos.add(emprestimo);
        return emprestimo;

    }
}



