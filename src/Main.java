import java.util.ArrayList;
import java.util.Scanner;
import model.Usuario;
import view.TelaInicial;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        TelaInicial.telaInicial(scanner);

        fecharScanner();
    }
    private static void fecharScanner() {
        scanner.close();
    }
}
