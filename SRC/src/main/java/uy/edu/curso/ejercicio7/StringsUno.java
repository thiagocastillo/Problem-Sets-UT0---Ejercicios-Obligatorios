package uy.edu.curso.ejercicio7;

public class StringsUno {

    public static void main(String[] args) {
        System.out.println("-- Ejercicio de Strings --");

        // El tema con String es que es Inmutable en java. Si le quiero cambiar una
        // letra o algo, por atrás borra y te crea flor de objeto nuevo consumiendo
        // memoria a lo bobo si lo haces en un ciclo muy largo.

        String hannah = "Did Hannah see bees? Hannah did.";
        String frase = "Anita lava la tina";

        System.out.println("1. Tal cual viene: " + hannah);
        System.out.println("2. toLowerCase (todo a minuscula): " + hannah.toLowerCase());
        System.out.println("3. toUpperCase (grita todo): " + frase.toUpperCase());
        System.out.println("4. trim (saca espacios de los bordes): '" + "   ahora   ".trim() + "'");
        
        System.out.println("5. replace (le cambio las A por O): " + frase.replace('a', 'o'));
        // Uso regex para limpiar la mugre (puntuacion y espacios)
        System.out.println("6. replaceAll (con regex limpia full): " + hannah.replaceAll("[\\s\\?\\.]", "").toLowerCase());
        System.out.println("7. replaceFirst: " + hannah.replaceFirst("Hannah", "John"));

        System.out.println("8. contiene 'bees'?: " + hannah.contains("bees"));
        System.out.println("9. ¿Donde arranca la primera Hannah?: " + hannah.indexOf("Hannah"));
        System.out.println("10. ¿Donde arranca la última Hannah?: " + hannah.lastIndexOf("Hannah"));

        System.out.println("11. split por espacios (separo las palabras):");
        String[] partes = hannah.split(" ");
        for (String p : partes) {
            System.out.println("  " + p);
        }

        System.out.println("\n-- Microconsultas --");
        // Qué tan largo es
        System.out.println("Largo de string: " + hannah.length());
        
        // Qué letra hay acá
        System.out.println("Letra del índice 4: " + hannah.charAt(4));

        // Metemos cacho
        String pedacito = hannah.substring(4, hannah.indexOf(" ", 4));
        System.out.println("Sacar pedacito del texto: " + pedacito);
        
        // Hace medio lo mismo pero devuelve otro tipo de dato en java
        CharSequence sec = hannah.subSequence(4, hannah.indexOf(" ", 4));
        System.out.println("Con el subSequence: " + sec);
    }
}
