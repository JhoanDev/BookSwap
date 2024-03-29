package controller;

import java.util.Scanner;
import model.CadastroModel;

public class Cadastro {

    public static void cadastro(Scanner scanner) {
        boolean cadastrado = false;
        while (!cadastrado) {
            try {
                System.out.println("Cadastro de Usuário:");

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("Login: ");
                String login = scanner.nextLine();

                System.out.print("Senha: ");
                String senha = scanner.nextLine();

                System.out.print("Instituição: ");
                String instituicao = scanner.nextLine();

                cadastrado = true;
                CadastroModel.finalizaCadastro(nome, login, email, senha, instituicao);
                System.out.println("Usuário cadastrado com sucesso!\n");
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                System.out.println("Tente novamente.\n");
            }
        }
    }
}