package uy.edu.curso.ejercicio12;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class DepuracionTest {

    @Test
    void testMainMetodosCorregidos() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Ejecutar los métodos corregidos no debe lanzar excepción
        Depuracion.main(new String[]{});
        
        String log = outContent.toString();
        // Verificamos que se ejecutó exitosamente la última parte NPECorregido
        assertTrue(log.contains("operación evitada"));
        
        System.setOut(System.out);
    }
}
