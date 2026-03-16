package uy.edu.curso.ejercicio7;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class StringsUnoTest {

    @Test
    void testMainEjecutaSinErroresYGeneraSalida() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        StringsUno.main(new String[]{});
        
        String salida = outContent.toString();
        assertTrue(salida.contains("hannah"));
        assertTrue(salida.contains("substring"));
        
        System.setOut(System.out);
    }
}
