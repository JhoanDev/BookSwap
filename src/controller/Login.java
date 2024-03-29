package controller;

import java.util.Scanner;
import model.Usuario;
import model.UsuariosRepo;

public class Login {

    public static int login(Scanner scanner) {
        boolean loggedIn = false;
        while (!loggedIn) {
            try {
                System.out.print("Insira seu login: ");
                String login = scanner.nextLine();
                System.out.print("Insira sua senha: ");
                String senha = scanner.nextLine();
                if (model.LoginModel.verificaLogin(login, senha)) {
                    System.out.println("Login bem-sucedido!\n");
                    loggedIn = true;
                    Usuario user =  UsuariosRepo.getInstance().getUsuario(login, senha);
                    int sair = Menu.menu(scanner, user);
                    if (sair == 1) return 1;
                } else {
                    throw new Exception("Login ou senha incorretos.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Tente novamente.\n");
            }
        }
        return 0;
    }
}
