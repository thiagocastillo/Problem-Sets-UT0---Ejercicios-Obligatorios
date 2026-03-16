package uy.edu.curso.ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PruebaAtributosTest {

    @Test
    void testValoresPorDefecto() {
        PruebaAtributos prueba = new PruebaAtributos();
        
        // Verifica que los valores primitivos y referencias tengan sus valores por defecto
        assertEquals(0, prueba.entero, "El entero por defecto debe ser 0");
        assertFalse(prueba.logico, "El boolean por defecto debe ser false");
        assertEquals(0.0, prueba.decimal, "El double por defecto debe ser 0.0");
        assertEquals('\u0000', prueba.caracter, "El char por defecto debe ser el caracter nulo");
        assertNull(prueba.cadena, "El String por defecto debe ser null");
    }
}
