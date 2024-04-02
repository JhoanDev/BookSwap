package controller;

import java.util.Scanner;

import model.Biblioteca;
import model.BibliotecaRepo;
import model.Usuario;

public class BibliotecaGeral {
    public static void bibliotecaGeralMenu(Scanner scanner, Usuario user) {
        BibliotecaRepo bGeral = BibliotecaRepo.getInstance();
        Biblioteca blibliotecaP = user.getBibliotecaPessoal();
        if (bGeral.getBiblioteca().getLivros().isEmpty()) {
            System.out.println("\nNenhum livro disponível.");
            Menu.menu(scanner, user);
        }
        System.out.println("\nLivros disponíveis:\n");
        for (int i = 0; i < bGeral.getBiblioteca().getLivros().size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + bGeral.getBiblioteca().getLivros().get(i));
        }
        System.out.println("[" + (bGeral.getBiblioteca().getLivros().size() + 1) + "] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == bGeral.getBiblioteca().getLivros().size() + 1){
                return;
            }
            if (opcao < 1 || opcao > bGeral.getBiblioteca().getLivros().size() + 1) {
                throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a "
                        + (bGeral.getBiblioteca().getLivros().size() + 1) + ".");
            }
            if (blibliotecaP.getLivro(bGeral.getBiblioteca().getLivros().get(opcao - 1).getTitulo()) != null){
                throw new IllegalArgumentException("Este Livro é seu.");
            }
            if (opcao == bGeral.getBiblioteca().getLivros().size() + 1) {
                Menu.menu(scanner, user);
            }
            System.out.println("\nLivro escolhido: " + bGeral.getBiblioteca().getLivros().get(opcao - 1));
            System.out.println("\n[1] - Solicitar troca");
            System.out.println("[2] - Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao2 = 0;
            try {
                opcao2 = Integer.parseInt(scanner.nextLine());
                if (opcao2 < 1 || opcao2 > 2) {
                    throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a 2.");
                }
                if (opcao2 == 1) {
                    System.out.println("Troca solicitada com sucesso.");
                    return;
                } else {
                    bibliotecaGeralMenu(scanner, user);
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Opção inválida. Por favor, digite um número.");
                bibliotecaGeralMenu(scanner, user);// Chama recursivamente o método para obter uma opção válida
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                bibliotecaGeralMenu(scanner, user); // Chama recursivamente o método para obter uma opção válida
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            bibliotecaGeralMenu(scanner, user);// Chama recursivamente o método para obter uma opção válida
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            bibliotecaGeralMenu(scanner, user); // Chama recursivamente o método para
        }
    }
}
