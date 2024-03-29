import java.util.Scanner;

import controller.TelaInicial;
import model.CadastroModel;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int sair;
        CadastroModel.cadastraInstituicao("UFERSA", "Pau dos ferros", "RN");
        CadastroModel.cadastraInstituicao("UFRN", "Natal", "RN");
        CadastroModel.cadastraInstituicao("UERN", "Mossoró", "RN");
        System.out.println("Bem vindo ao BookSwap\n");
        do {
            sair = TelaInicial.telaInicial(scanner);
        } while (sair != 1);
        fecharScanner();
    }

    private static void fecharScanner() {
        scanner.close();
    }
}
