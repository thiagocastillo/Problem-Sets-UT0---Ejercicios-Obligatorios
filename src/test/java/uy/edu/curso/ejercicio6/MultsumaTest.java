package uy.edu.curso.ejercicio6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MultsumaTest {

    @Test
    void testMultsumaDouble() {
        double resultado = Multsuma.multsuma(2.0, 3.0, 4.0); // 2 * 3 + 4
        assertEquals(10.0, resultado, 0.0001);
    }

    @Test
    void testMultsumaInt() {
        int resultado = Multsuma.multsuma(2, 3, 4); // 2 * 3 + 4
        assertEquals(10, resultado);
    }

    @Test
    void testMultiplicacionVectoresExito() {
        int[] v1 = {1, 2, 3};
        int[] v2 = {4, 5, 6};
        int[] esperado = {4, 10, 18}; // 1*4, 2*5, 3*6
        
        int[] resultado = Multsuma.multiplicarVectores(v1, v2);
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void testMultiplicacionVectoresFalloLongitud() {
        int[] v1 = {1, 2};
        int[] v2 = {4, 5, 6};
        
        int[] resultado = Multsuma.multiplicarVectores(v1, v2);
        // Debe retornar arreglo vacío si son de distinta longitud
        assertEquals(0, resultado.length);
    }

    @Test
    void testMultiplicacionVectoresNull() {
        int[] resultado = Multsuma.multiplicarVectores(null, new int[]{1});
        assertEquals(0, resultado.length);
    }
}
