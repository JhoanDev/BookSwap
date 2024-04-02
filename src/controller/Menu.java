package controller;

import java.util.Scanner;
import model.Usuario;

public class Menu {
    public static int menu(Scanner scanner, Usuario user) {
        System.out.println("\n[1] - Ver livros disponíveis");
        System.out.println("[2] - Perfil");
        System.out.println("[3] - Notificações");
        System.out.println("[4] - Minha biblioteca");
        System.out.println("[5] - Trocas");
        System.out.println("[6] - Logout");
        System.out.print("Escolha uma opção: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == 6) {
                TelaInicial.telaInicial(scanner);
            }
            if (opcao < 1 || opcao > 6) {
                throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a 6.");
            }
            switch (opcao) {
                case 1:
                    BibliotecaGeral.bibliotecaGeralMenu(scanner, user);
                    menu(scanner, user);
                    break;
                case 2:
                    Perfil.perfilMenu(scanner, user);
                    menu(scanner, user);
                    break;
                case 3:
                    System.out.println("Notificações");
                    menu(scanner, user);
                    break;
                case 4:
                    BibliotecaPessoal.livroMenu(scanner, user);
                    menu(scanner, user);
                    break;
                case 5:
                    System.out.println("Trocas");
                    menu(scanner, user);
                    break;
                case 6:
                    return 1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            return menu(scanner, user); // Chama recursivamente o método para obter uma opção válida
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return menu(scanner, user); // Chama recursivamente o método para obter uma opção válida
        }
        return 0;
    }
}
