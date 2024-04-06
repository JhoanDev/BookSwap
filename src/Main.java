import java.util.Scanner;

import controller.TelaInicial;
import model.BibliotecaRepo;
import model.InstituicoesRepo;
import model.Livro;
import model.Usuario;
import model.UsuariosRepo;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Dados pré-cadastrados
        // Cadastro de instituições
        InstituicoesRepo.cadastraInstituicao("UFERSA", "PAU DOS FERROS", "RN");
        InstituicoesRepo.cadastraInstituicao("UFRN", "NATAL", "RN");
        InstituicoesRepo.cadastraInstituicao("UERN", "MOSSORÓ", "RN");
        InstituicoesRepo.cadastraInstituicao("IFRN", "NATAL", "RN");
        InstituicoesRepo.cadastraInstituicao("UFPB", "JOÃO PESSOA", "PB");
        InstituicoesRepo.cadastraInstituicao("UFCG", "CAMPINA GRANDE", "PB");
        InstituicoesRepo.cadastraInstituicao("UPE", "RECIFE", "PE");
        InstituicoesRepo.cadastraInstituicao("UFPE", "RECIFE", "PE");
        InstituicoesRepo.cadastraInstituicao("UFRPE", "RECIFE", "PE");
        InstituicoesRepo.cadastraInstituicao("UNB", "BRASÍLIA", "DF");
        InstituicoesRepo.cadastraInstituicao("UFG", "GOIÂNIA", "GO");
        InstituicoesRepo.cadastraInstituicao("UFMG", "BELO HORIZONTE", "MG");
        
    
        // Cadastro de usuários e livros
        UsuariosRepo ur = UsuariosRepo.getInstance();
        InstituicoesRepo instituicoesRepo = InstituicoesRepo.getInstance();
    
        UsuariosRepo.cadastraUsuario("JHOAN", "jhoan.log", "jhoan@gmail.com", "13062004",
                instituicoesRepo.getInstituicao("UFERSA", "PAU DOS FERROS"));
        UsuariosRepo.cadastraUsuario("JOHN", "john.log", "john@gmail.com", "20040613",
                instituicoesRepo.getInstituicao("UFRN", "NATAL"));
    
        Usuario jhoan = ur.getUsuario("jhoan.log", "13062004");
        Usuario john = ur.getUsuario("john.log", "20040613");

        jhoan.adicionaLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "HarperCollins", 1954, 1, jhoan));
        jhoan.adicionaLivro(new Livro("1984", "George Orwell", "Editora Globo", 1949, 2, jhoan));
        jhoan.adicionaLivro(new Livro("Dom Quixote", "Miguel de Cervantes", "Real Academia Española", 1605, 3, jhoan));
    
        john.adicionaLivro(new Livro("O Hobbit", "J.R.R. Tolkien", "HarperCollins", 1937, 1, john));
        john.adicionaLivro(new Livro("A Revolução dos Bichos", "George Orwell", "Editora Globo", 1945, 2, john));
        john.adicionaLivro(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "Harper & Row", 1967, 3, john));
    
        // Adicionando livros à biblioteca geral
        BibliotecaRepo bibliotecaGeral = BibliotecaRepo.getInstance();
        for (Usuario usuario : ur.getAllUsuarios()) {
            for (Livro livro : usuario.getBibliotecaPessoal().getLivros()) {
                bibliotecaGeral.getBiblioteca().adicionarLivro(livro);
            }
        }
    
        System.out.println("\nBem-vindo ao BookSwap");
    
        TelaInicial.telaInicial(scanner);
        scanner.close();
    }
    
}
