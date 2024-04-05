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
        CadastroModel.cadastraInstituicao("UFERSA", "Pau dos Ferros", "RN");
        CadastroModel.cadastraInstituicao("UFRN", "Natal", "RN");
        CadastroModel.cadastraInstituicao("UERN", "Mossoró", "RN");
        CadastroModel.cadastraInstituicao("IFRN", "Natal", "RN");
        CadastroModel.cadastraInstituicao("UFPB", "João Pessoa", "PB");
        CadastroModel.cadastraInstituicao("UFCG", "Campina Grande", "PB");
        CadastroModel.cadastraInstituicao("UPE", "Recife", "PE");
        CadastroModel.cadastraInstituicao("UFPE", "Recife", "PE");
        CadastroModel.cadastraInstituicao("UFRPE", "Recife", "PE");
        CadastroModel.cadastraInstituicao("UNB", "Brasília", "DF");
        CadastroModel.cadastraInstituicao("UFG", "Goiânia", "GO");
        CadastroModel.cadastraInstituicao("UFMG", "Belo Horizonte", "MG");
    
        // Cadastro de usuários e livros
        UsuariosRepo ur = UsuariosRepo.getInstance();
        InstituicoesRepo instituicoesRepo = InstituicoesRepo.getInstance();
    
        CadastroModel.cadastraUsuario("Jhoan", "jhoan.log", "jhoan@gmail.com", "13062004",
                instituicoesRepo.getInstituicao("UFERSA", "Pau dos Ferros"));
        CadastroModel.cadastraUsuario("John", "john.log", "john@gmail.com", "20040613",
                instituicoesRepo.getInstituicao("UFRN", "Natal"));
    
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
