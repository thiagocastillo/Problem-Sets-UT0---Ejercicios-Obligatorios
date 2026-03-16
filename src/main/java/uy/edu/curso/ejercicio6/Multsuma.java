package uy.edu.curso.ejercicio6;

import java.util.Arrays;

public class Multsuma {

    // Función original
    public static double multsuma(double a, double b, double c) {
        return a * b + c;
    }

    // A esto se le dice sobrecarga: llamo a la función igual pero le paso distintos
    // tipos de datos (en este caso paso de double a int), entonces me deja tener las dos
    public static int multsuma(int a, int b, int c) {
        return a * b + c;
    }

    // Valido que anden bien para multiplicar dos arreglos, o sea que 
    // tengan algo adentro y midan lo mismo.
    public static int[] multiplicarVectores(int[] arregloA, int[] arregloB) {
        if (!estaTodoOk(arregloA, arregloB)) {
            System.err.println("Fijate que los arreglos no miden lo mismo, o de última están vacíos.");
            return new int[0]; // Devuelve array vacío para que no explote
        }
        return hacerProducto(arregloA, arregloB);
    }
    
    // Reviso precondiciones en un metodo aparte porque queda más prolijo
    private static boolean estaTodoOk(int[] arregloA, int[] arregloB) {
        return arregloA != null && arregloB != null && arregloA.length == arregloB.length;
    }

    // Itero a mano
    private static int[] hacerProducto(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] * arr2[i]; 
        }
        return result;
    }

    public static void imprimirArreglo(String txt, int[] arr) {
        System.out.println(txt + ": " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("Probando multsuma(double): " + multsuma(2.5, 2.0, 1.5));
        System.out.println("Probando multsuma(int): " + multsuma(2, 3, 4));

        int[] vecA = {1, 2, 3};
        int[] vecB = {4, 5, 6};
        System.out.println("\n== Multiplicación que arranca en verde ==");
        int[] sumaOk = multiplicarVectores(vecA, vecB);
        imprimirArreglo("Resultado lindo", sumaOk);

        int[] vecMal = {1, 2};
        int[] vecPeor = {1, 2, 3};
        System.out.println("\n== Multiplicación de distinto tamaño ==");
        int[] error = multiplicarVectores(vecMal, vecPeor);
        imprimirArreglo("Resultado trucho", error);
    }
}
