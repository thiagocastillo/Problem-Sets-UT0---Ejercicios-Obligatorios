package uy.edu.curso.ejercicio8;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class StringsDosTest {

    @Test
    void testMainEjecutaSinErroresYGeneraSalida() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        StringsDos.main(new String[]{});
        
        String salida = outContent.toString();
        assertTrue(salida.contains("StringBuilder"));
        assertTrue(salida.contains("literal1 == objeto: false")); // Prueba explicita de las demostraciones del pool
        
        System.setOut(System.out);
    }
}
