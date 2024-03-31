package controller;

import java.util.Scanner;

public class TelaInicial {

    public static int telaInicial(Scanner scanner) {
        while (true) {
            System.out.println("\n[1] - Logar");
            System.out.println("[2] - Cadastrar");
            System.out.println("[3] - Sair");
            System.out.print("Digite sua opcao: ");
            int opcao = 0;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1 || opcao == 2 || opcao == 3) {
                    System.out.println();
                    telaInicialCont(opcao, scanner);
                    if (opcao == 3) {
                        return 1;
                    }
                    break;
                } else {
                    System.out.println("Opção inválida. Por favor, digite uma opção valida\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, digite um número.\n");
                return telaInicial(scanner); // Chama recursivamente o método para obter uma opção válida
            }
        }
        return 0;
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
                System.out.println("Saindo...");

                break;   
        }
    }
}
