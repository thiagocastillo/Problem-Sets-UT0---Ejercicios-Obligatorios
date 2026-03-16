package uy.edu.curso.ejercicio2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ArithmeticDemoTest {

    @Test
    void testMainMethodNoArgs() {
        // Redirigir la salida estándar para poder leerla
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Ejecución sin argumentos
        ArithmeticDemo.main(new String[]{});
        
        // Verificar que el resultado de las operaciones encadenadas fue 3
        assertTrue(outContent.toString().contains("Resultado de ArithmeticDemo: 3"));
        
        // Restaurar salida original
        System.setOut(System.out);
    }
    
    @Test
    void testMainMethodWithArgs() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Ejecución con argumentos válidos
        ArithmeticDemo.main(new String[]{"10", "2"});
        
        String log = outContent.toString();
        assertTrue(log.contains("Suma: 12.0"));
        assertTrue(log.contains("Resta: 8.0"));
        assertTrue(log.contains("Multiplicación: 20.0"));
        assertTrue(log.contains("División: 5.0"));
        
        // Restaurar
        System.setOut(System.out);
    }
}
