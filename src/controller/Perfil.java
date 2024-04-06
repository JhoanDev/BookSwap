package controller;

import java.util.Scanner;

import model.Usuario;

public class Perfil {

    public static void perfilMenu(Scanner scanner, Usuario user) {
        System.out.println("\n[1] - Ver dados pessoais");
        System.out.println("[2] - Editar dados pessoais");
        System.out.println("[3] - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println(user);
                    perfilMenu(scanner, user);
                    break;
                case 2:
                    System.out.println("\nQual dado deseja editar?");
                    System.out.println("[1] - Nome");
                    System.out.println("[2] - Email");
                    System.out.println("[3] - Senha");
                    System.out.println("[4] - Universidade");
                    System.out.println("[5] - Sair");
                    System.out.print("Escolha uma opção: ");
                    int opcaoEditar = Integer.parseInt(scanner.nextLine());
                    switch (opcaoEditar) {
                        case 1:
                            System.out.print("Digite o novo nome: ");
                            user.setNome(scanner.nextLine());
                            System.out.println("Nome alterado com sucesso!");
                            perfilMenu(scanner, user);
                            break;
                        case 2:
                            System.out.print("Digite o novo email: ");
                            user.setEmail(scanner.nextLine());
                            System.out.println("Email alterado com sucesso!");
                            perfilMenu(scanner, user);
                            break;
                        case 3:
                            System.out.print("Digite a nova senha: ");
                            user.setSenha(scanner.nextLine());
                            System.out.println("Senha alterada com sucesso!");
                            perfilMenu(scanner, user);
                            break;
                        case 4:
                            System.out.print("Digite a nova universidade: ");
                            user.getUniversidade().setNome(scanner.nextLine());
                            System.out.println("Universidade alterada com sucesso!");
                            perfilMenu(scanner, user);
                            break;
                        case 5:
                            perfilMenu(scanner, user);
                            break;
                        default:
                            throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a 5.");
                    }
                    break;
                case 3:
                    System.out.println("\nSaindo...");
                    return;
                default:
                    throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a 3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            perfilMenu(scanner, user);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            perfilMenu(scanner, user);
        }
    }
}
