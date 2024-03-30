package controller;

import java.util.Scanner;

import model.Usuario;

public class BibliotecaPessoal {
    public static void livroMenu(Scanner scanner, Usuario user) {
        System.out.println("[1] - Adicionar livro");
        System.out.println("[2] - Remover livro");
        System.out.println("[3] - Listar livros");
        System.out.println("[4] - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("Adicionar livro");
                    // Implemente a lógica para adicionar um livro à bibliotca do usuário
                    
                    break;
                case 2:
                    System.out.println("Remover livro");
                    // Implemente a lógica para remover um livro da biblioteca do usuário
                    break;
                case 3:
                    System.out.println("Listar livros");
                    // Implemente a lógica para listar os livros na biblioteca do usuário
                    break;
                case 4:
                    System.out.println("Sair do menu de manipulação de livros");
                    break;
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
