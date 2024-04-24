package test.model;

import model.Tratativas;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;
// import org.mockito.Mockito;

public class TratativasTest {

    @Test
    public void testLeEVerificaNome() {
        String input = "Jo\nJo1\nJo  Jo\nJoao\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertEquals("JOAO", Tratativas.leEVerificaNome(scanner));
    }

    @Test
    public void testLeEVerificaLogin() {
        assertTrue(Tratativas.leEVerificaLogin("ab_1"));
        assertFalse(Tratativas.leEVerificaLogin("ab"));
        assertFalse(Tratativas.leEVerificaLogin("ab@"));
    }    

    @Test
    public void testLeEVerificaSenha() {
        String input = "1234567\n12345678\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        assertEquals("12345678", Tratativas.leEVerificaSenha(scanner));
    }

    /*  
    @Test
    public void testLeEVerificaNomeInstituicao() {
        Scanner scannerMock = Mockito.mock(Scanner.class);
        Mockito.when(scannerMock.nextLine()).thenReturn("UFERSA");
        String nomeInstituicao = Tratativas.leEVerificaNomeInstituicao(scannerMock);
        assertEquals("UFERSA", nomeInstituicao);
    }
    */

    /* 
    @Test
    public void testLeEVerificaCidadeInstituicao() {
        Scanner scannerMock = Mockito.mock(Scanner.class);
        Mockito.when(scannerMock.nextLine()).thenReturn("PAU DOS FERROS");
        String cidade = Tratativas.leEVerificaCidadeInstituicao(scannerMock);
        assertEquals("PAU DOS FERROS", cidade);
    }
    */
}
