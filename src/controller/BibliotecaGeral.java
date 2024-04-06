package controller;

import java.util.Scanner;

import model.Biblioteca;
import model.BibliotecaRepo;
import model.Livro;
import model.Troca;
import model.Usuario;

public class BibliotecaGeral {
    public static void bibliotecaGeralMenu(Scanner scanner, Usuario user) {
        Biblioteca bGeral = BibliotecaRepo.getInstance().getBiblioteca();
        Biblioteca blibliotecaP = user.getBibliotecaPessoal();
        if (bGeral.getQuantidadeLivros() == 0) {
            System.out.println("\nNenhum livro disponível.");
            Menu.menu(scanner, user);
            return;
        }
        System.out.println("\nLivros disponíveis:\n");
        int qntLivrosBGeral = bGeral.getQuantidadeLivros();
        for (int i = 0; i < qntLivrosBGeral; i++) {
            System.out.println("[" + (i + 1) + "] - " + bGeral.getLivros().get(i));
        }
        System.out.println("[" + (bGeral.getLivros().size() + 1) + "] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = obterOpcao(scanner, qntLivrosBGeral+1);
        if (opcao == qntLivrosBGeral + 1)  return; //opção de voltar
        Livro livroEscolhido = bGeral.getLivros().get(opcao - 1);
        if (blibliotecaP.getLivro(livroEscolhido.getTitulo()) != null) { //se o livro já está na biblioteca pessoal
            System.out.println("Este Livro é seu.");
            bibliotecaGeralMenu(scanner, user);
            return;
        }
        System.out.println("\nLivro escolhido: " + livroEscolhido);
        System.out.println("\n[1] - Solicitar troca");
        System.out.println("[2] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao2 = obterOpcao(scanner, 2);
        if (opcao2 == 1) {
            realizarTroca(scanner, user, blibliotecaP,livroEscolhido);
        } else {
            bibliotecaGeralMenu(scanner, user);
        }
    }

    private static int obterOpcao(Scanner scanner, int maxOpcao) {
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao < 1 || opcao > maxOpcao) {
                throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a " + maxOpcao + ".");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            return obterOpcao(scanner, maxOpcao);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return obterOpcao(scanner, maxOpcao);
        }
        return opcao;
    }

    private static void realizarTroca(Scanner scanner, Usuario user, Biblioteca blibliotecaP, Livro livro) {
        System.out.println("\nEscolha um livro seu para troca:");
        int qntLivrosBPessoal = blibliotecaP.getQuantidadeLivros();
        for (int i = 0; i < qntLivrosBPessoal; i++) {
            System.out.println("[" + (i + 1) + "] - " + blibliotecaP.getLivros().get(i));
        }
        System.out.println("[" + (qntLivrosBPessoal + 1) + "] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao3 = obterOpcao(scanner, qntLivrosBPessoal + 1);
        if (opcao3 == qntLivrosBPessoal + 1) {
            bibliotecaGeralMenu(scanner, user);
            return;
        }
        Livro livroEscolhidoP = blibliotecaP.getLivros().get(opcao3 - 1);
        System.out.println("\nLivro escolhido: " + livroEscolhidoP);
        System.out.println("\nSolicitação de troca enviada.");
        System.out.println("Aguarde a confirmação do outro usuário.");
        Usuario eu = livroEscolhidoP.getDono();
        Usuario outro = livro.getDono();
        Troca troca = new Troca(livroEscolhidoP, livro);
        eu.addTrocaEmAndamento(troca);
        outro.addTrocaEmAndamento(troca);
        Menu.menu(scanner, user);
    }
}
