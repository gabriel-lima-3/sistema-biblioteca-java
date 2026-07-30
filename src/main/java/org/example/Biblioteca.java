package org.example;
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

    public void listarLivros(){

         int contador =0;
        if(livros.isEmpty()) {
            System.out.println("A biblioteca esta vazia");
            return;
        }

        for (Livro l : livros) {

            System.out.println(contador + " - " +l);
            contador++;

        }
    }

    public void cadastrarLivro(Livro livro){
        this.livros.add(livro);

    }

    public void cadastrarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void listarUsuarios(){

        if(usuarios.isEmpty()){
            System.out.println("Nao ha usuarios cadastrados");
            return;

        }

        for (Usuario u : usuarios){
            System.out.println(u);
        }
    }



    public void fazerEmprestimo(Livro livro, Usuario usuario){

        if(livro.getStatus() == Status.DISPONIVEL){

            livro.setStatus(Status.INDISPONIVEL);
            //Horario que foi feito o emprestimo
            LocalDateTime agora = LocalDateTime.now();
            //Horario que precisa entregar o livro
            LocalDateTime dataEntrega = LocalDateTime.now().plusDays(7);
            usuario.emprestarLivro(livro);
            Emprestimo emprestimo1 = new Emprestimo(livro, usuario, agora, dataEntrega);
            this.emprestimos.add(emprestimo1);
            System.out.println("Livro:" + livro.getAutor() + " foi alugado para:" + usuario.getNome());
        }else{
            System.out.println("livro indisponivel");

        }


    }



}



