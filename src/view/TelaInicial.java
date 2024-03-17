package view;


import java.util.Scanner;
import controller.TelaInicialController;

public class TelaInicial {

    public static void telaInicial(Scanner scanner) {
        while (true) {
            System.out.println("Bem vindo ao BookSwap");
            System.out.println("[1] - Logar");
            System.out.println("[2] - Cadastrar");
            System.out.print("Digite sua opcao: ");
            
            int opcao = 0;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1 || opcao == 2) {
                    TelaInicialController.telaInicialCont(opcao, scanner);
                    break;
                } else {
                    System.out.println("Opção inválida. Por favor, digite 1 ou 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, digite um número.");
            }
        }
    }
}
