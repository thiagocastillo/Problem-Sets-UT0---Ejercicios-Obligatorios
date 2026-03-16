package uy.edu.curso.ejercicio1;

public class PruebaAtributos {
    
    // Estos son los atributos de la clase (la JVM los inicializa solos)
    int entero;
    boolean logico;
    double decimal;
    char caracter;
    String cadena;

    /*
     * Nombres que andan bien:
     * int miVariable;
     * int _variable;
     * int variable1;
     * 
     * Nombres que rompen todo:
     * int 1variable; // No puede arrancar con número
     * int mi-variable; // El guión medio chilla
     * int mi variable; // Los espacios no van
     * int class; // Palabra prohibida porque así se definen las clases
     */

    public void mostrarValoresPorDefecto() {
        System.out.println("--- Valores por defecto ---");
        System.out.println("int: " + entero);
        System.out.println("boolean: " + logico);
        System.out.println("double: " + decimal);
        System.out.println("char: [" + caracter + "]");
        System.out.println("String: " + cadena);
    }

    public void probarVariablesLocales() {
        // Esta es una variable local, a diferencia de los atributos, esta NO se inicializa sola
        int enteroLocal;
        
        // Si descomento la linea de abajo el programa ni me deja compilar
        // System.out.println(enteroLocal); 
        
        /* 
         * Básicamente: los atributos son parte del objeto y Java les pone un valor por defecto.
         * En cambio a las variables locales que pones adentro de las funciones les tenés 
         * que dar bola e inicializarlas vos mismo antes de usarlas, sino chilla.
         */
    }

    public static void main(String[] args) {
        PruebaAtributos prueba = new PruebaAtributos();
        prueba.mostrarValoresPorDefecto();
        prueba.probarVariablesLocales();
    }
}
