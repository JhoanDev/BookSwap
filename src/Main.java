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
        // dados pre-cadastrados
        CadastroModel.cadastraInstituicao("UFERSA", "Pau dos ferros", "RN");
        CadastroModel.cadastraInstituicao("UFRN", "Natal", "RN");
        CadastroModel.cadastraInstituicao("UERN", "Mossoró", "RN");
        CadastroModel.cadastraUsuario("Jhoan", "jhoan.log", "jhoan@gmail.com", "123",
            InstituicoesRepo.getInstance().getInstituicao("UFERSA"));
        CadastroModel.cadastraUsuario("John", "john.log", "john@gmail.com", "456",
            InstituicoesRepo.getInstance().getInstituicao("UFRN"));
        UsuariosRepo ur = UsuariosRepo.getInstance();
        Usuario user2 = ur.getUsuario("john.log", "456");
        user2.adicionaLivro(new Livro("Book4", "Author4", "Publisher4", 2004, 4, user2));
        user2.adicionaLivro(new Livro("Book5", "Author5", "Publisher5", 2005, 5, user2));
        Usuario user = ur.getUsuario("jhoan.log", "123");
        user.adicionaLivro(new Livro("Book1", "Author1", "Publisher1", 2001, 1, user));
        user.adicionaLivro(new Livro("Book2", "Author2", "Publisher2", 2002, 2, user));
        user.adicionaLivro(new Livro("Book3", "Author3", "Publisher3", 2003, 3, user));
        BibliotecaRepo bGeral = BibliotecaRepo.getInstance();
        bGeral.getBiblioteca().adicionarLivro(new Livro("Book4", "Author4", "Publisher4", 2004, 4, user2));
        bGeral.getBiblioteca().adicionarLivro(new Livro("Book5", "Author5", "Publisher5", 2005, 5, user2));
        bGeral.getBiblioteca().adicionarLivro(new Livro("Book1", "Author1", "Publisher1", 2001, 1, user2));
        bGeral.getBiblioteca().adicionarLivro(new Livro("Book2", "Author2", "Publisher2", 2002, 2, user2));
        bGeral.getBiblioteca().adicionarLivro(new Livro("Book3", "Author3", "Publisher3", 2003, 3, user2));

        System.out.println("\nBem vindo ao BookSwap");

        TelaInicial.telaInicial(scanner);
        scanner.close();
    }
}
