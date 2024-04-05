package controller;

import java.util.Scanner;

public class TelaInicial {

    public static void telaInicial(Scanner scanner) {
        while (true) {
            System.out.println("\n[1] - Logar");
            System.out.println("[2] - Cadastrar");
            System.out.println("[3] - Sair");
            System.out.print("Digite sua opcao: ");
            int opcao = 0;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1 || opcao == 2 || opcao == 3) {
                    telaInicialCont(opcao, scanner);
                    break;
                } else {
                    System.out.println("Opção inválida. Por favor, digite uma opção valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, digite um número.");
            }
        }
        return;
    }

    public static void telaInicialCont(int op, Scanner scanner){
        switch (op) {
            case 1:
                Login.login(scanner);
                break;
            case 2:
                Cadastro.cadastro(scanner);
                break;
            default:
                scanner.close();
                System.exit(0);
                return;
        }
    }
}
