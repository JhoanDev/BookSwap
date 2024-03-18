import java.util.Scanner;
import view.TelaInicial;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int sair;
        do {
            sair = TelaInicial.telaInicial(scanner);
        } while (sair != 1);
        fecharScanner();
    }

    private static void fecharScanner() {
        scanner.close();
    }
}
