package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca b1 = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int escolha;


        do {
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
                    int genero1 = sc.nextInt();
                    sc.nextLine();
                    Genero genero = Genero.porOpcao(genero1);
                    Livro livro = new Livro(titulo, ano, autor, genero);
                    b1.cadastrarLivro(livro);

                    break;
                case 2:
                    System.out.println("Nome de usuario? \n");
                    String nome = sc.nextLine();
                    System.out.println("Email do usuario?");
                    String email = sc.nextLine();
                    System.out.println("Tipo de usuario: \n 1 - PROFESSOR \n 2 - ESTUDANTE \n 3 - VISITANTE");
                    int tipoDeUsuario = sc.nextInt();
                    sc.nextLine();
                    TipoDeUsuario tipoDeUsuario1 = TipoDeUsuario.pelaOpcao(tipoDeUsuario);
                    System.out.println("Idade?");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    Usuario usuario = new Usuario(nome, email, tipoDeUsuario1, idade );
                    b1.cadastrarUsuario(usuario);
                    break;
                case 3:

                    System.out.println("Livros disponiveis");
                    b1.listarLivros();
                    System.out.println("\n Digite o livro que quer escolher:\n ");
                    int escolhaDeLivro = sc.nextInt();
                    System.out.println("Digite seu nome de usuario \n");
                    b1.listarUsuarios();
                    int escolhaDeUsuario = sc.nextInt();
                    sc.nextLine();
                    b1.fazerEmprestimo(b1.getLivros().get(escolhaDeLivro), b1.getUsuarios().get(escolhaDeUsuario));
                    break;
                case 4:
                    b1.listarUsuarios();
                    break;
                case 5:
                    b1.listarLivros();
                    break;
                default:


            }
        } while (escolha != 6);
        {
            
            sc.close();
        }

    }

}