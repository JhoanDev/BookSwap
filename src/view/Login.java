package view;

import java.util.Scanner;

public class Login {

    public static void login(Scanner scanner) {
        boolean loggedIn = false;
        while (!loggedIn) {
            try {
                System.out.print("Insira seu login: ");
                String login = scanner.nextLine();
                System.out.print("Insira sua senha: ");
                String senha = scanner.nextLine();
                if (login.equals("admin") && senha.equals("admin")) {
                    System.out.println("Login bem-sucedido!");
                    loggedIn = true;
                } else {
                    throw new Exception("Login ou senha incorretos.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Tente novamente.");
            }
        }
    }
}
