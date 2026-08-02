package org.example;
import org.example.Exceptions.BibliotecaException;
import org.example.Exceptions.LivroIndisponivelException;
import org.example.Exceptions.LivroNaoEncontradoException;
import org.example.Exceptions.UsuarioNaoEncontradoException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca b1 = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int escolha =0;
        do {
            try{

            System.out.println("===Menu====");
            System.out.println("1-Cadastrar livro");
            System.out.println("2-Cadastrar Usuario");
            System.out.println("3-Fazer emprestimo");
            System.out.println("4-Listar usuarios");
            System.out.println("5-listar Livros");
            System.out.println("6-Fechar");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Titulo do livro? ");
                    String titulo = sc.nextLine();
                    System.out.println("Ano do livro? \n ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Autor do livro? ");
                    String autor = sc.nextLine();
                    System.out.println("Gênero:\n1 - TERROR\n2 - COMÉDIA\n3 - ROMANCE\n4 - AVENTURA");
                    int genero = sc.nextInt();
                    sc.nextLine();
                    Genero generoEnum = Genero.porOpcao(genero);
                    Livro livro = new Livro(titulo, ano, autor, generoEnum);
                    b1.cadastrarLivro(livro);
                    break;
                case 2:
                    System.out.println("Nome de usuario? \n");
                    String nome = sc.nextLine();
                    System.out.println("Email do usuario?");
                    String email = sc.nextLine();
                    System.out.println("Tipo de usuario: \n 1 - PROFESSOR \n 2 - ESTUDANTE \n 3 - VISITANTE");
                    int tipoDeUsuario1 = sc.nextInt();
                    sc.nextLine();
                    TipoDeUsuario tipoDeUsuario = TipoDeUsuario.pelaOpcao(tipoDeUsuario1);
                    System.out.println("Idade?");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    Usuario usuario = new Usuario(nome, email, tipoDeUsuario, idade );
                    b1.cadastrarUsuario(usuario);
                    break;
                case 3:
                    if(b1.getLivros().isEmpty() || b1.getUsuarios().isEmpty()){
                        System.out.println("Cadastre pelo menos um livro e um usuario");
                        break;
                    }

                    System.out.println("Livros disponiveis");
                    imprimirLivros(b1.getLivros());
                    System.out.println("\n Digite o nome do livro que quer escolher:\n ");
                    String livroTitulo = sc.nextLine();


                    System.out.println("Digite seu nome de usuario \n");
                    imprimirUsuarios(b1.getUsuarios());
                    String usuarioNome = sc.nextLine();

                    Livro livroEscolha = b1.buscarLivroPeloTitulo(livroTitulo)
                            .orElseThrow(() -> new LivroNaoEncontradoException("Livro: " + livroTitulo + " nao encontrado"));

                    Usuario usuarioEscolha = b1.buscarUsuarioPeloNome(usuarioNome)
                                    .orElseThrow(()-> new UsuarioNaoEncontradoException("Usuario: " + usuarioNome +  " nao encontrado"));

                    b1.fazerEmprestimo(livroEscolha, usuarioEscolha);

                    break;
                case 4:
                    imprimirUsuarios(b1.getUsuarios());
                    break;
                case 5:
                    imprimirLivros(b1.getLivros());
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }

            } catch (InputMismatchException e) {
                System.out.println("Digito invalido");
                sc.nextLine();
            } catch (BibliotecaException e) {
                System.out.println(e.getMessage());
            }



        }while(escolha!=6);
        sc.close();

    }


    public static void imprimirLivros(List<Livro> livros){
             int contador = 0;

            if (livros.isEmpty()) {
                System.out.println("Nao ha livros cadastrados");
                return;

            }

            for (Livro l : livros) {
                System.out.println(contador + " - " + l);
                contador++;
            }
    }


    public static void imprimirUsuarios(List<Usuario> usuarios){

        int contador =0;
        if (usuarios.isEmpty()) {
            System.out.println("Nao ha usuarios cadastrados");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println(contador + " - " + u);
            contador++;
        }
    }




}