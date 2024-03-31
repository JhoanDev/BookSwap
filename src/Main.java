import java.util.Scanner;

import controller.TelaInicial;
import model.CadastroModel;
import model.InstituicoesRepo;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int sair;
        // dados pre-cadastrados
        CadastroModel.cadastraInstituicao("UFERSA", "Pau dos ferros", "RN");
        CadastroModel.cadastraInstituicao("UFRN", "Natal", "RN");
        CadastroModel.cadastraInstituicao("UERN", "Mossoró", "RN");
        CadastroModel.cadastraUsuario("Jhoan", "jhoan.log","jhoan@gmail.com", "123",
        InstituicoesRepo.getInstance().getInstituicao("UFERSA"));

        System.out.println("\n\nBem vindo ao BookSwap");
        do {
            sair = TelaInicial.telaInicial(scanner);
        } while (sair != 1);
        fecharScanner();
    }

    private static void fecharScanner() {
        scanner.close();
    }
}
