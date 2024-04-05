package controller;

import java.util.Scanner;
import model.CadastroModel;
import model.Instituicao;
import model.InstituicoesRepo;

public class Cadastro {

    public static void cadastro(Scanner scanner) {
        boolean cadastrado = false;
        int tentativas = 0;
        
        while (!cadastrado && tentativas < 3) {
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

                System.out.print("Nome da instituição: ");
                String nomeInstituicao = scanner.nextLine();

                System.out.print("Cidade da instituição: ");
                String cidade = scanner.nextLine();
        
                
                Instituicao instituicao = InstituicoesRepo.getInstance().getInstituicao(nomeInstituicao, cidade);

                if (instituicao != null) {
                    cadastrado = true;
                    CadastroModel.cadastraUsuario(nome, login, email, senha, instituicao);
                    System.out.println("Usuário cadastrado com sucesso!\n");
                    return;
                } else {
                    System.out.println("Instituição inválida. Por favor, insira um nome de instituição válido.\n");
                    tentativas++;
                }
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                System.out.println("Tente novamente.\n");
                tentativas++;
            }
        }
        if (!cadastrado) {
            System.out.println("Limite de tentativas excedido. Cadastro cancelado.\n");
            return;
        }
    }
}
