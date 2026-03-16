package uy.edu.curso.ejercicio14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para TransformadorT9.
 */
class TransformadorT9Test {

    private TransformadorT9 transformador;

    @BeforeEach
    void setUp() {
        transformador = new TransformadorT9();
    }

    // 1. Test básico
    @Test
    void testConvertirAT9Basico() {
        String resultado = transformador.convertirAT9("hola");
        // h=44, o=666, l=555, a=2 -> 446665552
        assertEquals("446665552", resultado);
    }

    // 2. Test parametrizado
    @ParameterizedTest
    @CsvSource({
            "'foo', '333666 666'", // f=333, o=666, pausa, o=666
            "'bar', '22 2777'",    // b=22, a=2 (pausa), r=777
            "'', ''"               // Cadena vacía
    })
    void testConvertirAT9Parametrizado(String entrada, String salidaEsperada) {
        assertEquals(salidaEsperada, transformador.convertirAT9(entrada));
    }

    // 3. Test de texto invertido
    @Test
    void testConvertirAT9Invertido() {
        String resultado = transformador.convertirAT9Invertido("aloh"); // aloh invertido es hola
        assertEquals("446665552", resultado);
    }

    // 4. Test que verifica Excepción
    @Test
    void testTransformarArchivoLanzaExcepcionSiNoExiste() {
        assertThrows(IOException.class, () -> {
            transformador.transformarArchivo("archivo_inexistente_12345.txt", "salida.txt", false);
        });
    }

    // 5. Test con Timeout
    @Test
    void testRendimientoEnTextosLargos() {
        StringBuilder textoLargo = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            textoLargo.append("hola mundo ");
        }
        
        // Verifica que la conversión masiva termine en menos de 1 segundo (usualmente tomará milisegundos)
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            transformador.convertirAT9(textoLargo.toString());
        });
    }
}
