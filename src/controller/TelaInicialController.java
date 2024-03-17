package controller;

import java.util.Scanner;

import view.Login;

public class TelaInicialController {
    public static void telaInicialCont(int op, Scanner scanner){
        if (op == 1) {
            Login.login(scanner);
        }
        else{
            System.out.println("Cadastrando...");
        }
    }
}
