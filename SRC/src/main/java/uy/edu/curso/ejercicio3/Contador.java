package uy.edu.curso.ejercicio3;

import java.util.Scanner;

public class Contador {
    
    public final int MAX_CONT;
    public int incremento;
    public int contador;
    
    // Esto es para probar la diferencia. La variable static es compartida 
    // por todas las instancias de la clase, mientras que los demás son propios de cada objeto.
    public static int cuentaObjetos = 0;

    public Contador(int maxCont, int incremento) {
        this.MAX_CONT = maxCont;
        this.incremento = incremento;
        this.contador = 0;
        cuentaObjetos++; 
    }

    public void probarWhile() {
        System.out.println("== Ej de While ==");
        contador = 0;
        while (contador <= MAX_CONT) {
            System.out.print(contador + " - ");
            contador += incremento;
        }
        System.out.println();
    }

    public void probarDoWhile() {
        System.out.println("== Ej de Do-While ==");
        contador = 0;
        if (contador <= MAX_CONT) { 
            do {
                System.out.print(contador + " - ");
                contador += incremento;
            } while (contador <= MAX_CONT);
        }
        System.out.println();
    }

    public void probarFor() {
        System.out.println("== Ej de For ==");
        for (contador = 0; contador <= MAX_CONT; contador += incremento) {
            System.out.print(contador + " - ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Contador miContador = new Contador(20, 3);
        
        System.out.println("Contadores creados: " + Contador.cuentaObjetos); 
        
        System.out.println("Elegí con qué bucle iterar:");
        System.out.println("1 - while\n2 - do-while\n3 - for");
        System.out.print("Elegir: ");
        
        if (scan.hasNextInt()) {
            int opc = scan.nextInt();
            switch (opc) {
                case 1: miContador.probarWhile(); break;
                case 2: miContador.probarDoWhile(); break;
                case 3: miContador.probarFor(); break;
                default: System.out.println("Esa no la tengo."); break;
            }
        } else {
            System.out.println("Tiraste cualquier tecla.");
        }
        
        scan.close();
        
        // Creamos otro para verificar la variable statica
        Contador otro = new Contador(10, 2);
        System.out.println("Contadores creados al final: " + Contador.cuentaObjetos); 
    }
}
