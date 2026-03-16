package uy.edu.curso.ejercicio13;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class AnalizadorEnumTest {

    @Test
    void testClasificarCaracter() {
        assertEquals(TipoCaracter.VOCAL, AnalizadorEnum.clasificarCaracter('A'));
        assertEquals(TipoCaracter.VOCAL, AnalizadorEnum.clasificarCaracter('u'));
        
        assertEquals(TipoCaracter.CONSONANTE, AnalizadorEnum.clasificarCaracter('Z'));
        assertEquals(TipoCaracter.CONSONANTE, AnalizadorEnum.clasificarCaracter('b'));
        
        assertEquals(TipoCaracter.DIGITO, AnalizadorEnum.clasificarCaracter('5'));
        
        assertEquals(TipoCaracter.ESPECIO_BLANCO, AnalizadorEnum.clasificarCaracter(' '));
        assertEquals(TipoCaracter.ESPECIO_BLANCO, AnalizadorEnum.clasificarCaracter('\n'));
        
        assertEquals(TipoCaracter.OTRO, AnalizadorEnum.clasificarCaracter('.'));
        assertEquals(TipoCaracter.OTRO, AnalizadorEnum.clasificarCaracter('@'));
    }

    @Test
    void testAnalizarTextoGeneraSalidaCorrecta() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        AnalizadorEnum.analizarTexto("¡Hola Java 17!");
        
        String log = outContent.toString();
        // vocales: o, a, a, a -> 4
        // consonantes: h, l, j, v -> 4
        // digitos: 1, 7 -> 2
        // espacios: 2
        // otros: ¡, ! -> 2
        
        assertTrue(log.contains("Vocales: 4"));
        assertTrue(log.contains("Consonantes: 4"));
        assertTrue(log.contains("Dígitos: 2"));
        assertTrue(log.contains("Espacios: 2"));
        assertTrue(log.contains("Otros: 2"));
        
        System.setOut(System.out);
    }
}
