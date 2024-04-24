package test.model;

import model.Instituicao;
import model.InstituicoesRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstituicoesRepoTest {
    private InstituicoesRepo repo;

    @BeforeEach
    public void setUp() {
        repo = InstituicoesRepo.getInstance();
    }

    @AfterEach
    public void tearDown() {
        repo.limparLista();
    }

    @Test
    public void testAddInstituicao() {
        int initialSize = repo.getQntInstituicoes();
        InstituicoesRepo.cadastraInstituicao("Teste", "Teste", "Teste");
        assertEquals(initialSize + 1, repo.getQntInstituicoes());
    }

    @Test
    public void testGetInstituicao() {
        InstituicoesRepo.cadastraInstituicao("Teste", "Teste", "Teste");
        Instituicao instituicao = repo.getInstituicao("Teste", "Teste");
        assertNotNull(instituicao);
        assertEquals("Teste", instituicao.getNome());
        assertEquals("Teste", instituicao.getCidade());
    }

    @Test
    public void testExisteEssaInstituicaoN() {
        InstituicoesRepo.cadastraInstituicao("Teste", "Teste", "Teste");
        assertTrue(repo.existeEssaInstituicaoN("Teste"));
        assertFalse(repo.existeEssaInstituicaoN("Não Existe"));
    }

    @Test
    public void testExisteEssaInstituicaoC() {
        InstituicoesRepo.cadastraInstituicao("Teste", "Teste", "Teste");
        assertTrue(repo.existeEssaInstituicaoC("Teste"));
        assertFalse(repo.existeEssaInstituicaoC("Não Existe"));
    }

    // novos testes
    @Test
    public void testAddInstituicaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            InstituicoesRepo.cadastraInstituicao("", "cidade", "estado");  // nome vazio
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InstituicoesRepo.cadastraInstituicao("nome", "", "estado");  // cidade vazia
        });
    }

    @Test
    public void testAddInstituicaoDuplicada() {
        InstituicoesRepo.cadastraInstituicao("Teste", "Teste", "Teste");
        assertThrows(IllegalArgumentException.class, () -> {
            InstituicoesRepo.cadastraInstituicao("Teste", "Teste", "Teste");  // instituição duplicada
        });
    }

    @Test
    public void testGetInstituicaoInexistente() {
        assertNull(repo.getInstituicao("Não Existe", "Não Existe"));
    }

    @Test
    public void testExisteEssaInstituicaoNInexistente() {
        assertFalse(repo.existeEssaInstituicaoN("Não Existe"));
    }

    @Test
    public void testExisteEssaInstituicaoCInexistente() {
        assertFalse(repo.existeEssaInstituicaoC("Não Existe"));
    }

}
