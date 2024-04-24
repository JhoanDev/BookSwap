package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Tratativas {

    public static String leEVerificaNome(Scanner scanner) {
        String nome;
        do {
            System.out.print("Digite o nome: ");
            nome = scanner.nextLine();
            if (nome.length() < 3) {
                System.out.println("Nome inválido. Deve conter no mínimo 3 caracteres.");
            } else if (contemDigitos(nome)) {
                System.out.println("Nome inválido. Não pode conter dígitos numéricos.");
            } else if (contemDoisEspacosSeguidos(nome)) {
                System.out.println("Nome inválido. Não pode conter dois espaços seguidos.");
            }
        } while (nome.length() < 3 || contemDigitos(nome) || contemDoisEspacosSeguidos(nome));
        nome = nome.toUpperCase();
        return nome;
    }

    // leEVerificaLogin
    public static boolean leEVerificaLogin(String login) {
        UsuariosRepo usuarioRepo = UsuariosRepo.getInstance();
        return isValidoLogin(login) && !usuarioRepo.existeEsseLogin(login);
    }
    
    public static String leEVerificaSenha(Scanner scanner) {
        String senha;
        do {
            System.out.print("Digite a senha: ");
            senha = scanner.nextLine();
            if (senha.length() < 8) {
                System.out.println("Senha inválida. Deve conter no mínimo 8 caracteres.");
            }
        } while (senha.length() < 8);
        return senha;
    }

    public static String leEVerificaNomeInstituicao(Scanner scanner) {
        String nomeInstituicao;
        InstituicoesRepo instituicaoRepo = InstituicoesRepo.getInstance();
        do {
            System.out.print("Digite o nome da instituição: ");
            nomeInstituicao = scanner.nextLine();
            nomeInstituicao = nomeInstituicao.toUpperCase();
            if (!instituicaoRepo.existeEssaInstituicaoN(nomeInstituicao)) {
                System.out.println("Instituição inválida. Por favor, insira um nome de instituição válido.");
            }
            else {
                break;
            }
        } while (true);
        return nomeInstituicao;
    }

    public static String leEVerificaCidadeInstituicao(Scanner scanner) {
        String cidade;
        InstituicoesRepo instituicaoRepo = InstituicoesRepo.getInstance();
        do {
            System.out.print("Digite a cidade da instituição: ");
            cidade = scanner.nextLine();
            cidade = cidade.toUpperCase();
            if (!instituicaoRepo.existeEssaInstituicaoC(cidade)) {
                System.out.println("Cidade inválida. Por favor, insira uma cidade válida.");
            }
            else {
                break;
            }
        } while (true);
        return cidade;
    }

    public static boolean isValidoLogin(String login) {
        return login.matches("^[a-zA-Z0-9_.]{3,}$");
    }
    

    public static String leEVerificaEmail(Scanner scanner) {
        String email;
        do {
            System.out.print("Digite o email: ");
            email = scanner.nextLine();
            if (!isValidoEmail(email)) {
                System.out.println("Email inválido. Por favor, insira um email válido.");
            }
        } while (!isValidoEmail(email));
        return email;
    }

    public static boolean isValidoEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean contemDigitos(String nome) {
        for (char c : nome.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contemDoisEspacosSeguidos(String nome) {
        for (int i = 0; i < nome.length() - 1; i++) {
            if (nome.charAt(i) == ' ' && nome.charAt(i + 1) == ' ') {
                return true;
            }
        }
        return false;
    }
}
