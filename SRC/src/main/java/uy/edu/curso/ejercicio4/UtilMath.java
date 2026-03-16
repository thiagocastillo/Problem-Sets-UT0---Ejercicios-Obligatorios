package uy.edu.curso.ejercicio4;

public class UtilMath {

    // Saca el factorial de un número con un for de toda la vida
    public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("No hay factorial para negativos che.");
        }
        if (num > 20) {
            // Arriba de 21 ya el long se queda corto y desborda
            throw new IllegalArgumentException("Ese número es muy grande, probá con uno más chico (hasta 20).");
        }
        
        long res = 1;
        for (int i = 2; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    // Se fija si un número es primo iterando hasta la raíz cuadrada
    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        
        // Si es par y no es el 2, no es primo
        if (n % 2 == 0) return false;
        
        // Arranco a buscar divisores impares
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Calcula la suma posta dependiendo si n es primo o no
    public static long sumaCondicional(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Pasame un número positivo.");
        }
        
        boolean esPrimo = isPrime(n);
        long acumulador = 0;
        long nActual = 0;
        
        // Si n es primo, le sumo los pares entre 0 y n
        // Si no es primo, le sumo los impares
        
        while (nActual <= n) {
            if (esPrimo) {
                if (nActual % 2 == 0) acumulador += nActual;
            } else {
                if (nActual % 2 != 0) acumulador += nActual;
            }
            nActual++;
        }
        return acumulador;
    }
}
