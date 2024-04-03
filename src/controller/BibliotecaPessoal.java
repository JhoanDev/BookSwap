package controller;

import java.util.Scanner;

import model.BibliotecaRepo;
import model.Livro;
import model.Usuario;

public class BibliotecaPessoal {
    public static void livroMenu(Scanner scanner, Usuario user) {
        System.out.println("\n[1] - Adicionar livro");
        System.out.println("[2] - Remover livro");
        System.out.println("[3] - Listar livros");
        System.out.println("[4] - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    System.out.print("\ninsira o nome do livro: ");
                    String nome = scanner.nextLine();
                    System.out.print("insira o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("insira o ano do livro: ");
                    int ano = Integer.parseInt(scanner.nextLine());
                    System.out.print("insira o editora do livro: ");
                    String editora = scanner.nextLine();
                    System.out.print("insira o edicao do livro: ");
                    int edicao = Integer.parseInt(scanner.nextLine());
                    user.adicionaLivro(new Livro(nome, autor, editora, ano, edicao, user));
                    BibliotecaRepo.getInstance().getBiblioteca().adicionarLivro(new Livro(nome, autor, editora, ano, edicao, user));
                    livroMenu(scanner, user);
                    break;
                case 2:
                    System.out.print("\nInsira o nome do livro que deseja remover:");
                    String nomeLivro = scanner.nextLine();
                    user.removeLivro(nomeLivro);
                    livroMenu(scanner, user);
                    break;
                case 3:
                    if (user.getLivros().isEmpty()) {
                        System.out.println("\nNenhum livro cadastrado.");
                        livroMenu(scanner, user);
                    }
                    System.out.println("\nLivros do usuario:\n");
                    for (Livro livro : user.getLivros()) {
                        System.out.println(livro);
                    }
                    livroMenu(scanner, user);
                    break;
                case 4:
                    System.out.println("\nSaindo...");
                    return;
                default:
                    throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a 4.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            livroMenu(scanner, user); // Chama recursivamente o método para obter uma opção válida
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            livroMenu(scanner, user); // Chama recursivamente o método para obter uma opção válida
        }
    }
}
