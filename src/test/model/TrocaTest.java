package test.model;

import model.Troca;
import model.Livro;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrocaTest {
    private Usuario usuario1;
    private Usuario usuario2;
    private Livro livro1;
    private Livro livro2;
    private Troca troca;

    @BeforeEach
    public void setUp() {
        usuario1 = new Usuario("Teste1", "teste1", "teste1@teste.com", "senha1", null, 10001);
        usuario2 = new Usuario("Teste2", "teste2", "teste2@teste.com", "senha2", null, 10002);
        livro1 = new Livro("Teste1", "Autor Teste1", "Editora Teste1", 2024, 1, usuario1);
        livro2 = new Livro("Teste2", "Autor Teste2", "Editora Teste2", 2024, 1, usuario2);
        troca = new Troca(livro1, livro2);
    }

    @AfterEach
    public void tearDown() {
        // Limpa os dados após cada teste
        usuario1 = null;
        usuario2 = null;
        livro1 = null;
        livro2 = null;
        troca = null;
    }

    @Test
    public void testGetLivro1() {
        assertEquals(livro1, troca.getLivro1());
    }

    @Test
    public void testGetLivro2() {
        assertEquals(livro2, troca.getLivro2());
    }

    @Test
    public void testAprovar() {
        troca.aprovar();
        assertEquals("Troca do livro 'Teste1' pelo livro 'Teste2' (Realizada)", troca.toString());
    }

    @Test
    public void testRejeitar() {
        troca.rejeitar();
        assertEquals("Troca do livro 'Teste1' pelo livro 'Teste2' (Cancelada)", troca.toString());
    }

    @Test
    public void testAprovarERejeitar() {
        troca.aprovar();
        troca.rejeitar();
        assertEquals("Troca do livro 'Teste1' pelo livro 'Teste2' (Realizada)", troca.toString());
    }

    @Test
    public void testRejeitarEAprovar() {
        troca.rejeitar();
        troca.aprovar();
        assertEquals("Troca do livro 'Teste1' pelo livro 'Teste2' (Cancelada)", troca.toString());
    }
}
