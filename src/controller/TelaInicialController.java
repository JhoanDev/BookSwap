package controller;

import java.util.Scanner;

import view.Cadastro;
import view.Login;

public class TelaInicialController {
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
