package view;

import java.util.Scanner;
import controller.TelaInicialController;

public class TelaInicial {

    public static int telaInicial(Scanner scanner) {
        while (true) {
            System.out.println("[1] - Logar");
            System.out.println("[2] - Cadastrar");
            System.out.println("[3] - Sair");
            System.out.print("Digite sua opcao: ");

            int opcao = 0;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1 || opcao == 2 || opcao == 3) {
                    System.out.println();
                    TelaInicialController.telaInicialCont(opcao, scanner);
                    if (opcao == 3) {
                        return 1;
                    }
                    break;
                } else {
                    System.out.println("Opção inválida. Por favor, digite 1 ou 2.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, digite um número.\n");
                return telaInicial(scanner); // Chama recursivamente o método para obter uma opção válida
            }
        }
        return 0;
    }
}
