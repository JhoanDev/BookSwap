package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Usuario;
import model.UsuariosRepo;

public class Login {

    public static void login(Scanner scanner) {
        boolean loggedIn = false;
        try {
            System.out.println("Pressione 1 para continuar inserindo o login ou qualquer outro número para voltar.");
            int option = Integer.parseInt(scanner.nextLine());
            if (option != 1) {
                return;
            }
            while (!loggedIn) {
                try {
                    System.out.print("Insira seu login: ");
                    String login = scanner.nextLine();
                    System.out.print("Insira sua senha: ");
                    String senha = scanner.nextLine();
                    
                    Usuario user = UsuariosRepo.getInstance().getUsuario(login, senha);
                    
                    if (user != null) {
                        System.out.println("\nLogin bem-sucedido!");
                        loggedIn = true;
                        Menu.menu(scanner, user);
                    } else {
                        throw new Exception("Login ou senha incorretos.");
                    }
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    System.out.println("Tente novamente.\n");
                    login(scanner);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
            scanner.nextLine(); // Limpar o buffer de entrada
            login(scanner); // Chamar recursivamente para tentar novamente
        }
    }
}
