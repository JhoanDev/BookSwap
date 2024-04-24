package test.model;


import model.Usuario;
import model.UsuariosRepo;
import model.Instituicao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuariosRepoTest {
    private UsuariosRepo usuariosRepo;
    private Usuario usuario1;
    private Usuario usuario2;

    
    @BeforeEach
    public void setUp() {
        usuariosRepo = UsuariosRepo.getInstance();
        Instituicao universidade = new Instituicao("Universidade Teste");
        usuario1 = new Usuario("Teste1", "teste1", "teste1@teste.com", "senha1", universidade, 10001);
        usuario2 = new Usuario("Teste2", "teste2", "teste2@teste.com", "senha2", universidade, 10002);
    }

    @AfterEach
    public void tearDown() {
        // Limpa os dados após cada teste
        usuariosRepo.getAllUsuarios().clear();
    }

    @Test
    public void testAddUsuario() {
        usuariosRepo.addUsuario(usuario1);
        assertEquals(1, usuariosRepo.getQntUsuarios());
        assertEquals(usuario1, usuariosRepo.getUsuario("Teste1"));
    }

    @Test
    public void testGetUsuario() {
        usuariosRepo.addUsuario(usuario1);
        usuariosRepo.addUsuario(usuario2);
        assertEquals(usuario1, usuariosRepo.getUsuario("Teste1"));
        assertEquals(usuario2, usuariosRepo.getUsuario("Teste2"));
        assertNull(usuariosRepo.getUsuario("Teste3"));
    }

    @Test
    public void testExisteEsseLogin() {
        usuariosRepo.addUsuario(usuario1);
        assertTrue(usuariosRepo.existeEsseLogin("teste1"));
        assertFalse(usuariosRepo.existeEsseLogin("teste3"));
    }

    @Test
    public void testCadastraUsuario() {
        UsuariosRepo.cadastraUsuario("Teste3", "teste3", "teste3@teste.com", "senha3", new Instituicao("Universidade Teste3"));
        assertEquals(1, usuariosRepo.getQntUsuarios());
        assertNotNull(usuariosRepo.getUsuario("Teste3"));
    }

    @Test
    public void testVerificaLogin() {
        usuariosRepo.addUsuario(usuario1);
        assertTrue(UsuariosRepo.verificaLogin("teste1", "senha1"));
        assertFalse(UsuariosRepo.verificaLogin("teste1", "senha2"));
        assertFalse(UsuariosRepo.verificaLogin("teste2", "senha1"));
    }
}
