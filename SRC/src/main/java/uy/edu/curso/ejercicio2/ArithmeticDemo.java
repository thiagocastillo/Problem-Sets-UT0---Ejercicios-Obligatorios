package uy.edu.curso.ejercicio2;

public class ArithmeticDemo {
    public static void main(String[] args) {
        int result = 1 + 2; // queda en 3
        
        // Cambié todo a operadores compuestos para ahorrar código
        result -= 1; // queda en 2
        result *= 2; // queda en 4
        result /= 2; // queda en 2
        result += 8; // queda en 10
        result %= 7; // queda en 3

        System.out.println("Resultado: " + result);

        /* 
         * ¿Qué pasa en 'int a = 5; int i = 3; a += ++i;'?
         * Primero el ++i le suma 1 a la variable i, dejandola en 4.
         * Después ese 4 se lo suma a la variable 'a' (5 + 4), por lo que 'a' termina valiendo 9.
         */
         
         // Probando pasar parametros por consola
         if (args.length >= 2) {
             System.out.println("\n--- Probando con argumentos ---");
             try {
                 // Paso los args a double
                 double v1 = Double.parseDouble(args[0]);
                 double v2 = Double.parseDouble(args[1]);
                 
                 System.out.println("Suma: " + (v1 + v2));
                 System.out.println("Resta: " + (v1 - v2));
                 System.out.println("Multiplicación: " + (v1 * v2));
                 
                 // Controlo el cero para no romper todo
                 if (v2 != 0) {
                     System.out.println("División: " + (v1 / v2));
                 } else {
                     System.out.println("No se puede dividir por cero :(");
                 }
             } catch (NumberFormatException e) {
                 System.out.println("Tira error si no mandas números. Acordate de mandar números che.");
             }
         }
    }
}
