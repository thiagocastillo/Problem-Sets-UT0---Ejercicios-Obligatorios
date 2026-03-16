package uy.edu.curso.ejercicio3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContadorTest {

    @Test
    void testInicializacionContador() {
        Contador c = new Contador(20, 5);
        assertEquals(20, c.MAX_CONT);
        assertEquals(5, c.incremento);
        assertEquals(0, c.contador);
    }

    @Test
    void testConteoWhile() {
        Contador c = new Contador(15, 5);
        c.probarWhile();
        // Después de probarWhile (0, 5, 10, 15), el contador queda incrementado en el último paso no válido.
        // Mientras c <= 15:
        // c=0 -> suma 5 (c=5)
        // c=5 -> suma 5 (c=10)
        // c=10 -> suma 5 (c=15)
        // c=15 -> suma 5 (c=20)
        // Termina while.
        assertEquals(20, c.contador);
    }

    @Test
    void testConteoDoWhile() {
        Contador c = new Contador(10, 3);
        c.probarDoWhile();
        // 0 -> 3 -> 6 -> 9 -> 12 (termina)
        assertEquals(12, c.contador);
    }

    @Test
    void testConteoFor() {
        Contador c = new Contador(5, 1);
        c.probarFor();
        // for termina cuando contador > MAX_CONT
        assertEquals(6, c.contador);
    }

    @Test
    void testVariableEstatica() {
        int instanciasPrevias = Contador.cuentaObjetos;
        new Contador(10, 1);
        new Contador(10, 1);
        assertEquals(instanciasPrevias + 2, Contador.cuentaObjetos);
    }
}
