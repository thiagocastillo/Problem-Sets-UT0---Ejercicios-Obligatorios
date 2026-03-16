package uy.edu.curso.ejercicio4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilMathTest {

    @Test
    void testFactorialValidos() {
        assertEquals(1, UtilMath.factorial(0));
        assertEquals(1, UtilMath.factorial(1));
        assertEquals(120, UtilMath.factorial(5));
        assertEquals(3628800, UtilMath.factorial(10));
    }

    @Test
    void testFactorialExcepciones() {
        assertThrows(IllegalArgumentException.class, () -> UtilMath.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> UtilMath.factorial(21)); // Muy grande para long
    }

    @Test
    void testIsPrime() {
        assertFalse(UtilMath.isPrime(-5));
        assertFalse(UtilMath.isPrime(0));
        assertFalse(UtilMath.isPrime(1));
        assertTrue(UtilMath.isPrime(2)); // Primer primo par
        assertTrue(UtilMath.isPrime(3));
        assertFalse(UtilMath.isPrime(4));
        assertTrue(UtilMath.isPrime(17));
        assertTrue(UtilMath.isPrime(97));
        assertFalse(UtilMath.isPrime(100));
    }

    @Test
    void testSumaCondicionalPrimo() {
        // n=5, es primo -> suma pares entre 0 y 5: 0, 2, 4 -> suma=6
        assertEquals(6, UtilMath.sumaCondicional(5));
        
        // n=2, es primo -> suma pares entre 0 y 2: 0, 2 -> suma=2
        assertEquals(2, UtilMath.sumaCondicional(2));
    }

    @Test
    void testSumaCondicionalNoPrimo() {
        // n=6, no es primo -> suma impares entre 0 y 6: 1, 3, 5 -> suma=9
        assertEquals(9, UtilMath.sumaCondicional(6));
        
        // n=9, no es primo -> suma impares entre 0 y 9: 1, 3, 5, 7, 9 -> suma=25
        assertEquals(25, UtilMath.sumaCondicional(9));
    }
}
