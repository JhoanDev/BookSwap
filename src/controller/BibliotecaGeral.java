package controller;

import java.util.Scanner;

import model.Biblioteca;
import model.BibliotecaRepo;
import model.Livro;
import model.Troca;
import model.Usuario;

public class BibliotecaGeral {
    public static void bibliotecaGeralMenu(Scanner scanner, Usuario user) {
        BibliotecaRepo bGeral = BibliotecaRepo.getInstance();
        Biblioteca blibliotecaP = user.getBibliotecaPessoal();
        if (bGeral.getBiblioteca().getLivros().isEmpty()) {
            System.out.println("\nNenhum livro disponível.");
            Menu.menu(scanner, user);
            return;
        }
        System.out.println("\nLivros disponíveis:\n");
        for (int i = 0; i < bGeral.getBiblioteca().getLivros().size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + bGeral.getBiblioteca().getLivros().get(i));
        }
        System.out.println("[" + (bGeral.getBiblioteca().getLivros().size() + 1) + "] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = obterOpcao(scanner, bGeral.getBiblioteca().getLivros().size() + 1);
        if (opcao == bGeral.getBiblioteca().getLivros().size() + 1) {
            Menu.menu(scanner, user);
            return;
        }
        if (blibliotecaP.getLivro(bGeral.getBiblioteca().getLivros().get(opcao - 1).getTitulo()) != null) {
            System.out.println("Este Livro é seu.");
            bibliotecaGeralMenu(scanner, user);
            return;
        }
        System.out.println("\nLivro escolhido: " + bGeral.getBiblioteca().getLivros().get(opcao - 1));
        System.out.println("\n[1] - Solicitar troca");
        System.out.println("[2] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao2 = obterOpcao(scanner, 2);
        if (opcao2 == 1) {
            realizarTroca(scanner, user, blibliotecaP,bGeral.getBiblioteca().getLivros().get(opcao - 1));
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
        for (int i = 0; i < blibliotecaP.getLivros().size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + blibliotecaP.getLivros().get(i));
        }
        System.out.println("[" + (blibliotecaP.getLivros().size() + 1) + "] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao3 = obterOpcao(scanner, blibliotecaP.getLivros().size() + 1);
        if (opcao3 == blibliotecaP.getLivros().size() + 1) {
            bibliotecaGeralMenu(scanner, user);
            return;
        }
        Livro livroEscolhido = blibliotecaP.getLivros().get(opcao3 - 1);
        System.out.println("\nLivro escolhido: " + livroEscolhido);
        System.out.println("\nSolicitação de troca enviada.");
        System.out.println("Aguarde a confirmação do outro usuário.");
        Usuario eu = blibliotecaP.getLivros().get(opcao3 - 1).getDono();
        Usuario outro = livro.getDono();
        Troca aux = new Troca(livroEscolhido, livro);
        eu.addTrocaEmAndamento(aux);
        outro.addTrocaEmAndamento(aux);
        aux.aprovar();
        Menu.menu(scanner, user);
    }
}
