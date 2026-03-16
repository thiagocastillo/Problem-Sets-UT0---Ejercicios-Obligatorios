package uy.edu.curso.ejercicio11;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class PrincipalTest {

    @Test
    void testLeerEntradaArchivoFormatoValido() throws IOException {
        File temp = File.createTempFile("test_principal_", ".txt");
        temp.deleteOnExit();
        try (FileWriter fw = new FileWriter(temp)) {
            // Se formatea usando el locale por defecto para asegurar que Scanner lo parsee bien
            String valorReal = String.format("%.1f", 4.5);
            fw.write("10\n" + valorReal + "\nTexto de prueba");
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Principal.leerEntradaArchivo(temp.getAbsolutePath());

        String log = outContent.toString();
        assertTrue(log.contains("Entero leido: 10"));
        assertTrue(log.contains("Real leido: 4.5"));
        assertTrue(log.contains("Cadena leida: Texto de prueba"));

        System.setOut(System.out);
    }

    @Test
    void testLeerEntradaStdin() {
        // Simulando System.in (radio = 5.0).
        // Dependiendo del Locale podría esperar coma o punto. 
        // Generamos un test simple inyectando input.
        String input = "5,0\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Para evitar que en máquinas con locale EN falle por "," se puede proveer "5.0"
        // Atrapamos la posible excepción (InputMismatchException) del test si falla el locale:
        try {
            Principal.leerEntradaStdin();
        } catch (Exception e) {
            // Reintentar con el otro formato:
            System.setIn(new ByteArrayInputStream("5.0\n".getBytes()));
            Principal.leerEntradaStdin();
        }

        String log = outContent.toString();
        // Área = PI * 5^2 =~ 78.5398
        assertTrue(log.contains("78,53") || log.contains("78.53"));

        System.setIn(originalIn);
        System.setOut(System.out);
    }
}
