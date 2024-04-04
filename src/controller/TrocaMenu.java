package controller;

import java.util.Scanner;

import model.Mensagem;
import model.Troca;
import model.Usuario;

public class TrocaMenu {
    public static void trocaMenu(Scanner scanner, Usuario user) {
        System.out.println("\n[1] - Trocas em andamento");
        System.out.println("[2] - Trocas finalizadas");
        System.out.println("[3] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == 3) {
                return;
            }
            if (opcao < 1 || opcao > 3) {
                throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a 3.");
            }
            switch (opcao) {
                case 1:
                    trocasAndamento(scanner, user);
                    trocaMenu(scanner, user);
                    break;
                case 2:
                    trocasFinalizadas(scanner, user);
                    trocaMenu(scanner, user);
                    break;
                case 3:
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            trocaMenu(scanner, user); // Chama recursivamente o método para obter uma opção válida
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            trocaMenu(scanner, user); // Chama recursivamente o método para obter uma opção válida
        }
    }

    public static void trocasAndamento(Scanner scanner, Usuario user) {
        System.out.println("\nTrocas em andamento:");
        if (user.getTrocasEmAndamento().isEmpty()) {
            System.out.println("Nenhuma troca em andamento.");
            return;
        }
        ;
        for (int i = 0; i < user.getTrocasEmAndamento().size(); i++) {
            if (user.getTrocasEmAndamento().get(i).getLivro1().getDono().equals(user)) {
                System.out.println(
                        "[" + (i + 1) + "] - " + user.getTrocasEmAndamento().get(i) + " ![Falta o outro aprovar]");
            } else {
                System.out.println("[" + (i + 1) + "] - " + user.getTrocasEmAndamento().get(i));
            }
        }
        System.out.println("[" + (user.getTrocasEmAndamento().size() + 1) + "] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == user.getTrocasEmAndamento().size() + 1) {
                return;
            }
            if (opcao < 1 || opcao > user.getTrocasEmAndamento().size() + 1) {
                throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a "
                        + (user.getTrocasEmAndamento().size() + 1) + ".");
            }
            Troca trocaEscolhida = user.getTrocasEmAndamento().get(opcao - 1);
            if (trocaEscolhida.getLivro1().getDono().equals(user)) {
                System.out.println("\nVocê já aprovou esta troca");
                return;
            }
            System.out.println("\nTroca escolhida: " + trocaEscolhida);
            System.out.println("\n[1] - Finalizar troca");
            System.out.println("[2] - Rejeitar troca");
            System.out.println("[3] - Enviar mensagem");
            System.out.println("[4] - Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao2 = 0;
            try {
                opcao2 = Integer.parseInt(scanner.nextLine());
                if (opcao2 == 4) {
                    return;
                }
                if (opcao2 < 1 || opcao2 > 4) {
                    throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a 4.");
                }
                switch (opcao2) {
                    case 1:
                        trocaEscolhida.aprovar();
                        trocaEscolhida.finalizar();
                        System.out.println("Troca finalizada com sucesso.");
                        return;
                    case 2:
                        trocaEscolhida.rejeitar();
                        System.out.println("Troca rejeitada.");
                        return;
                    case 3:
                        System.out.print("Digite a mensagem: ");
                        String mensagem = scanner.nextLine();

                        Usuario destinatario;
                        if (trocaEscolhida.getLivro1().getDono().getNome() == user.getNome()) {
                            destinatario = trocaEscolhida.getLivro2().getDono();
                        } else {
                            destinatario = trocaEscolhida.getLivro1().getDono();
                        }
                        Mensagem mensagemObj = new Mensagem(mensagem, user, destinatario);
                        destinatario.adicionaMensagem(mensagemObj);
                        user.adicionaMensagem(mensagemObj);
                        System.out.println("Mensagem enviada com sucesso.");
                        return;
                    case 4:
                        return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Opção inválida. Por favor, digite um número.");
                trocasAndamento(scanner, user); // Chama recursivamente o método para obter uma opção válida
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                trocasAndamento(scanner, user); // Chama recursivamente o método para obter uma opção válida
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            trocasAndamento(scanner, user); // Chama recursivamente o método para obter uma opção válida
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            trocasAndamento(scanner, user); // Chama recursivamente o método para obter uma opção válida
        }
    }

    public static void trocasFinalizadas(Scanner scanner, Usuario user) {
        System.out.println("Trocas finalizadas:");
        if (user.getTrocasFinalizadas().isEmpty()) {
            System.out.println("Nenhuma troca finalizada.");
            return;
        }
        for (int i = 0; i < user.getTrocasFinalizadas().size(); i++) {
            System.out.println("" + (i + 1) + " -> " + user.getTrocasFinalizadas().get(i));
        }
        System.out.println();
    }
}