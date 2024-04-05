import java.util.Scanner;

import controller.TelaInicial;
import model.BibliotecaRepo;
import model.CadastroModel;
import model.InstituicoesRepo;
import model.Livro;
import model.Usuario;
import model.UsuariosRepo;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Dados pré-cadastrados
        // Cadastro de instituições
        CadastroModel.cadastraInstituicao("UFERSA", "PAU DOS FERROS", "RN");
        CadastroModel.cadastraInstituicao("UFRN", "NATAL", "RN");
        CadastroModel.cadastraInstituicao("UERN", "MOSSORÓ", "RN");
        CadastroModel.cadastraInstituicao("IFRN", "NATAL", "RN");
        CadastroModel.cadastraInstituicao("UFPB", "JOÃO PESSOA", "PB");
        CadastroModel.cadastraInstituicao("UFCG", "CAMPINA GRANDE", "PB");
        CadastroModel.cadastraInstituicao("UPE", "RECIFE", "PE");
        CadastroModel.cadastraInstituicao("UFPE", "RECIFE", "PE");
        CadastroModel.cadastraInstituicao("UFRPE", "RECIFE", "PE");
        CadastroModel.cadastraInstituicao("UNB", "BRASÍLIA", "DF");
        CadastroModel.cadastraInstituicao("UFG", "GOIÂNIA", "GO");
        CadastroModel.cadastraInstituicao("UFMG", "BELO HORIZONTE", "MG");
        
    
        // Cadastro de usuários e livros
        UsuariosRepo ur = UsuariosRepo.getInstance();
        InstituicoesRepo instituicoesRepo = InstituicoesRepo.getInstance();
    
        CadastroModel.cadastraUsuario("JHOAN", "jhoan.log", "jhoan@gmail.com", "13062004",
                instituicoesRepo.getInstituicao("UFERSA", "PAU DOS FERROS"));
        CadastroModel.cadastraUsuario("JOHN", "john.log", "john@gmail.com", "20040613",
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
            for (Livro livro : usuario.getLivros()) {
                bibliotecaGeral.getBiblioteca().adicionarLivro(livro);
            }
        }
    
        System.out.println("\nBem-vindo ao BookSwap");
    
        TelaInicial.telaInicial(scanner);
        scanner.close();
    }
    
}
