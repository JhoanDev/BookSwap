package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Usuario;
import model.UsuariosRepo;

public class Login {

    public static void login(Scanner scanner) {
        boolean loggedIn = false;
        int attempts = 0;
        while (!loggedIn && attempts < 3) {
            try {
                System.out.print("\nInsira seu login: ");
                String login = scanner.hasNextLine() ? scanner.nextLine() : "";
                System.out.print("Insira sua senha: ");
                String senha = scanner.hasNextLine() ? scanner.nextLine() : "";
    
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
    
                System.out.println("Pressione 1 para continuar inserindo o login ou qualquer outro número para voltar.");
                try {
                    int option = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;
                    if (option != 1) {
                        return;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
                    if (scanner.hasNextLine()) {
                        scanner.nextLine(); // Limpar o buffer de entrada
                    }
                }
            }
            attempts++;
        }
    }
    
    

}
