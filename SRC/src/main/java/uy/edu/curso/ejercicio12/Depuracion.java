package uy.edu.curso.ejercicio12;

/*
 * ==== MIS ANOTACIONES PARA DEPURE O BUGS DEL REPARTIDO ====
 * 
 * --- Fragmento 1: Desborde en arreglo.
 * Problema real: Tiran array[10] en un Array que lo definieron de 10 max. Y pum. Da el "Index out of Bounds".
 * Por qué pasó: Las posiciones arrancan a contar desde el 0. La pos 10 seria el 11avo elemento.
 * Solución: Tenías que pedir la [9] o usar array[array.length - 1].
 * 
 * --- Fragmento 2: El clasico NullPointerException (NPE).
 * Problema real: Agarran una variable de texto, la igualan a null y le tiran texto.length().
 * Por qué pasó: No construyeron un objeto. Está en la nada misma y Java no lo puede medir.
 * Solución: Ponerle algo al string o validar primero onda "if texto != null" antes de tocar nada.
 * 
 * --- Fragmento 3: Comparar Texto y romper.
 * Problema real: Hacen "hola" == "hola" pero guardados en String u objetos distintos. Y les dice False.
 * Por qué pasó: Objeto contra Objeto el doble igual (==) compara si estan en el mismísimo lugar en la memoria de la ram, ignora el texto interno.
 * Solución: Usar str1.equals(str2) que revisa letra por letra posta.
 * 
 * - Qué hacer pra zafar esto a futuro:
 * 1. Mirar siempre que te tira el autocompletado del IDE (las linitas amarillas en eclipse/intellij te re avisan).
 * 2. Usar listas forEach para recorrer arrays en vez de usar for(int i=...) para safar de errarle a los indices.
 * 3. Asumir siempre que todo puede ser null y atajarlo con un if antes.
 */
public class Depuracion {

    public static void pruebaBugOutOfBounds() {
        int[] arreglito = new int[5]; // va de 0 a 4
        
        // Lo comento porque sino me tranca el flujo de pruebas unitarias dsp
        // System.out.println(arreglito[5]); // <--- BOOM
    }

    public static void sacarOutOfBoundsCorregido() {
        int[] arreglito = new int[5];
        System.out.println("Ultimo valor sano de la lista: " + arreglito[arreglito.length - 1]);
    }
    
    public static void pruebaBugNulo() {
        String testVacio = null;
        // System.out.println(testVacio.toUpperCase());  // <--- Te clava NullpointerException
    }

    public static void sacarBugNuloCorregido() {
        String texto = null;
        // Valido
        if (texto != null) {
            System.out.println(texto.toUpperCase()); 
        } else {
            System.out.println("Zafamos del fallo. Venía null la cosa.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Corriendo las versiones corregidas de los bugs:");
        sacarOutOfBoundsCorregido();
        sacarBugNuloCorregido();
    }
}
