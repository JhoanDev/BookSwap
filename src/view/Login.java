package view;

import java.util.Scanner;
import model.Usuario;
import model.UsuariosRepo;

public class Login {

    public static void login(Scanner scanner) {
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
                    UsuariosRepo userlist = UsuariosRepo.getInstance();
                    Usuario user = userlist.getUsuario(login, senha);
                    int sair = Menu.menu(scanner, user);
                    if (sair == 1) {
                        break;
                    }
                } else {
                    throw new Exception("Login ou senha incorretos.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Tente novamente.\n");
            }
        }
    }
}
