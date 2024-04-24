package test.controller;

import controller.Cadastro;
import model.Instituicao;
import model.InstituicoesRepo;
import model.UsuariosRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CadastroTest {

    private UsuariosRepo usuariosRepo;
    private InstituicoesRepo instituicoesRepo;

    @BeforeEach
    public void setUp() {
        usuariosRepo = UsuariosRepo.getInstance();
        instituicoesRepo = InstituicoesRepo.getInstance();
        // Adicione aqui as instituições de teste
        instituicoesRepo.cadastraInstituicao("UFERSA", "PAU DOS FERROS", "RN");
    }

    @Test
    public void testCadastroSuccess() {
        String input = "JHOAN\njhoan@gmail.com\njhoan.log\n13062004\nUFERSA\nPAU DOS FERROS\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(in);
        assertDoesNotThrow(() -> Cadastro.cadastro(scanner));
    }

    @Test
    public void testCadastroFail() {
        String input = "JHOAN\njhoan@gmail.com\njhoan.log\n13062004\nUFRN\nNATAL\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(in);
    
        // Redirecionar a saída padrão para um OutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    
        Cadastro.cadastro(scanner);
    
        // Verificar se a mensagem de erro esperada foi impressa
        assertTrue(outContent.toString().contains("Instituição inválida. Por favor, insira um nome de instituição válido."));
    }
    
}
