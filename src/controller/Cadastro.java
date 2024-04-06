package controller;

import java.util.Scanner;
import model.CadastroModel;
import model.Instituicao;
import model.InstituicoesRepo;
import model.Tratativas;

public class Cadastro {

    public static void cadastro(Scanner scanner) {
        boolean cadastrado = false;
        int tentativas = 0;
        
        while (!cadastrado && tentativas < 3) {
            try {
                System.out.println("\nCadastro de Usuário:\n");
                
                String nome = Tratativas.leEVerificaNome(scanner);
                String email = Tratativas.leEVerificaEmail(scanner);
                String login = Tratativas.leEVerificaLogin(scanner);
                String senha = Tratativas.leEVerificaSenha(scanner);
                String nomeInstituicao = Tratativas.leEVerificaNomeInstituicao(scanner);
                String cidade = Tratativas.leEVerificaCidadeInstituicao(scanner);
        
                Instituicao instituicao = InstituicoesRepo.getInstance().getInstituicao(nomeInstituicao, cidade);

                if (instituicao != null) {
                    cadastrado = true;
                    CadastroModel.cadastraUsuario(nome, login, email, senha, instituicao);
                    System.out.println("Usuário cadastrado com sucesso!\n");
                    TelaInicial.telaInicial(scanner);
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
