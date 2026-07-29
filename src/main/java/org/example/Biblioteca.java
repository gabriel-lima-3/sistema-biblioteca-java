package org.example;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Livro> livro = new ArrayList<>();
    List<Usuario> usuario = new ArrayList<>();
    List<Emprestimo> emprestimo = new ArrayList<>();

    public Biblioteca() {
    }

    public void cadastrarLivro(Livro livro){
        this.livro.add(livro);

    }
    public void listarLivros(){

         int contador =0;
        if(livro.isEmpty()) {
            System.out.println("A biblioteca esta vazia");
            return;
        }

        for (Livro l : livro) {

            System.out.println(contador + " - " +l);
            contador++;

        }
    }

    public void cadastrarUsuario(Usuario usuario){
        this.usuario.add(usuario);
    }

    public void listarUsuarios(){

        if(usuario.isEmpty()){
            System.out.println("Nao ha usuarios cadastrados");
            return;

        }

        for (Usuario u : usuario){
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
            usuario.getLivros().add(livro);
            Emprestimo emprestimo1 = new Emprestimo(livro, usuario, agora, dataEntrega);
            this.emprestimo.add(emprestimo1);
            System.out.println("Livro:" + livro.getAutor() + " foi alugado para:" + usuario.getNome());
        }else{
            System.out.println("livro indisponivel");

        }


    }



}



