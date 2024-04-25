package test.controller;

// import model.Usuario;
import controller.Login;
import model.UsuariosRepo;
import model.InstituicoesRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class LoginTest {

    private UsuariosRepo usuariosRepo;

    @BeforeEach
    public void setUp() {
        UsuariosRepo ur = UsuariosRepo.getInstance();
        InstituicoesRepo instituicoesRepo = InstituicoesRepo.getInstance();
    
        if (!instituicoesRepo.existeEssaInstituicaoN("UFERSA") || !instituicoesRepo.existeEssaInstituicaoC("PAU DOS FERROS")) {
            InstituicoesRepo.cadastraInstituicao("UFERSA", "PAU DOS FERROS", "RN");
        }
        UsuariosRepo.cadastraUsuario("DAYVISON", "dayve", "dayvison@gmail.com", "159149139",
        instituicoesRepo.getInstituicao("UFERSA", "PAU DOS FERROS"));
    }    

    @Test
    public void testLoginSuccess() {
        String input = "teste\n1234\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(in);
        assertDoesNotThrow(() -> Login.login(scanner));
    }

    @Test
    public void testLoginFail() {
        String input = "teste\nerrado\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(in);
    
        // Redirecionar a saída padrão para um OutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    
        Login.login(scanner);
    
        // Verificar se a mensagem de erro esperada foi impressa
        assertTrue(outContent.toString().contains("Erro: Login ou senha incorretos."));
    }
    
}
