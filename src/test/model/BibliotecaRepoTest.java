package test.model;

import model.BibliotecaRepo;
import model.Biblioteca;
import model.Livro;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaRepoTest {
    private Usuario usuario;
    private Livro livro1;
    private Livro livro2;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("Teste", "teste", "teste@teste.com", "senha", null, 10001);
        livro1 = new Livro("Teste1", "Autor Teste1", "Editora Teste1", 2024, 1, usuario);
        livro2 = new Livro("Teste2", "Autor Teste2", "Editora Teste2", 2024, 1, usuario);
    }

    @AfterEach
    public void tearDown() {
        // Limpa os dados após cada teste
        BibliotecaRepo.getInstance().removerBiblioteca();
    }

    @Test
    public void testGetInstance() {
        BibliotecaRepo bibliotecaRepo1 = BibliotecaRepo.getInstance();
        BibliotecaRepo bibliotecaRepo2 = BibliotecaRepo.getInstance();
        assertSame(bibliotecaRepo1, bibliotecaRepo2);
    }

    @Test
    public void testAdicionarERemoverLivro() {
        BibliotecaRepo bibliotecaRepo = BibliotecaRepo.getInstance();
        Biblioteca biblioteca = bibliotecaRepo.getBiblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        assertEquals(2, biblioteca.getQuantidadeLivros());
        assertEquals(livro1, biblioteca.getLivro("Teste1"));
        assertEquals(livro2, biblioteca.getLivro("Teste2"));

        biblioteca.removerLivro("Teste1");
        assertEquals(1, biblioteca.getQuantidadeLivros());
        assertNull(biblioteca.getLivro("Teste1"));
        assertEquals(livro2, biblioteca.getLivro("Teste2"));
    }

    @Test
    public void testRemoverLivroInexistente() {
        BibliotecaRepo bibliotecaRepo = BibliotecaRepo.getInstance();
        Biblioteca biblioteca = bibliotecaRepo.getBiblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.removerLivro("Teste2");
        assertEquals(1, biblioteca.getQuantidadeLivros());
        assertEquals(livro1, biblioteca.getLivro("Teste1"));
    }

    @Test
    public void testRemoverLivroDeBibliotecaVazia() {
        BibliotecaRepo bibliotecaRepo = BibliotecaRepo.getInstance();
        Biblioteca biblioteca = bibliotecaRepo.getBiblioteca();
        biblioteca.removerLivro("Teste1");
        assertEquals(0, biblioteca.getQuantidadeLivros());
    }
}
