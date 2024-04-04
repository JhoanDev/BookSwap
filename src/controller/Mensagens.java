package controller;

import java.util.Scanner;

import model.Mensagem;
import model.Usuario;

public class Mensagens {
    public static void mensagemMenu(Scanner scanner, Usuario user) {
        System.out.println("\n[1] - Ver mensagens");
        System.out.println("[2] - Limpar mensagens lidas");
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
                    verMensagens(scanner, user);
                    mensagemMenu(scanner, user);
                    break;
                case 2:
                    limparMensagensLidas(user);
                    mensagemMenu(scanner, user);
                    break;
                case 3:
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            mensagemMenu(scanner, user); // Chama recursivamente o método para obter uma opção válida
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            mensagemMenu(scanner, user); // Chama recursivamente o método para obter uma opção válida
        }
    }

    public static void verMensagens(Scanner scanner, Usuario user) {

        System.out.println("\nMensagens:");
        if (user.getMensagens().isEmpty()) {
            System.out.println("Nenhuma mensagem.");
            return;
        }
        for (int i = 0; i < user.getMensagens().size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + user.getMensagens().get(i));
        }
        System.out.println("[" + (user.getMensagens().size() + 1) + "] - Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == user.getMensagens().size() + 1) {
                return;
            }
            if (opcao < 1 || opcao > user.getMensagens().size() + 1) {
                throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a " + (user.getMensagens().size() + 1) + ".");
            }
            Mensagem mensagemEscolhida = user.getMensagens().get(opcao - 1);
            System.out.println("\nMensagem escolhida: " + mensagemEscolhida);
            System.out.println("\n[1] - Apagar mensagem");
            System.out.println("[2] - Responder");
            System.out.println("[3] - Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao2 = 0; 
            try {
                opcao2 = Integer.parseInt(scanner.nextLine());
                if (opcao2 == 3) {
                    return;
                }
                if (opcao2 < 1 || opcao2 > 3) {
                    throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma opção de 1 a 3.");
                }
                switch (opcao2) {
                    case 1:
                        user.getMensagens().remove(mensagemEscolhida);
                        System.out.println("Mensagem apagada para você.");
                        break;
                    case 2:
                        System.out.print("\nDigite a mensagem: ");
                        String mensagem = scanner.nextLine();
                        Usuario destinatarioUser;
                        if (mensagemEscolhida.getDestinatario().getNome() == user.getNome()) {
                            destinatarioUser = mensagemEscolhida.getRemetente();
                        }
                        else{
                            destinatarioUser = mensagemEscolhida.getDestinatario();
                        }
                        Mensagem novaMensagem = new Mensagem(mensagem, user, destinatarioUser);
                        destinatarioUser.adicionaMensagem(novaMensagem);
                        System.out.println("Mensagem enviada.");
                        verMensagens(scanner, user);
                        break;
                    case 3:
                        verMensagens(scanner, user);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Opção inválida. Por favor, digite um número.");
                verMensagens(scanner, user); // Chama recursivamente o método para obter uma opção válida
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                verMensagens(scanner, user); // Chama recursivamente o método para obter uma opção válida
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Por favor, digite um número.");
            verMensagens(scanner, user); // Chama recursivamente o método para obter uma opção válida
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            verMensagens(scanner, user); // Chama recursivamente o método para obter uma opção válida
        }
    }

    public static void limparMensagensLidas(Usuario user) {
        for (int i = 0; i < user.getMensagens().size(); i++) {
            if (user.getMensagens().get(i).isLida()) {
                user.getMensagens().remove(i);
                i--;
            }
        }
        System.out.println("Mensagens lidas apagadas.");
    }
}