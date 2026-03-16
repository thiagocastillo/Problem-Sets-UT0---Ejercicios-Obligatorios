package uy.edu.curso.ejercicio8;

public class StringsDos {
    public static void main(String[] args) {
        System.out.println("== Ejercicio de StringBuilder y Pool ==");

        // Al StringBuilder le podes meter un monton de append y modificaciones
        // y no te quema la RAM como el String común (no recrea el objeto).
        // Te re salva para cadenas armadas en bucles while o for.

        StringBuilder builder = new StringBuilder("Able was I ere I saw Elba.");

        System.out.println("Texto a pelo: " + builder.toString());
        System.out.println("Longitud: " + builder.length());
        // El capacity le suma + 16 a los 26 caracteres que tiene
        System.out.println("Capacidad inicial que le dio Java: " + builder.capacity());

        // Meto un montón de cosas seguidas en la misma línea
        builder.append(" Yes.")
               .insert(0, "Napoleon: ")
               .delete(9, 11) 
               .deleteCharAt(8); 

        System.out.println("\nYa modificado entero:");
        System.out.println(builder.toString());

        builder.reverse();
        System.out.println("\nY ahora dado vuelta:");
        System.out.println(builder.toString());

        // Achicamos a prepo
        builder.setLength(10);
        System.out.println("\nTexto mocho a 10 letras:");
        System.out.println(builder.toString());

        // Le digo que me asegure espacio para no laggear luego
        builder.ensureCapacity(100);
        System.out.println("Capacidad sobrada actual: " + builder.capacity());

        System.out.println("\n== Comparando Strings en Java ==");
        
        String t1 = "Pepe";
        String t2 = "Pepe";
        String obj = new String("Pepe"); // Esto lo forzás, no se recomienda

        // Pasa que == mira la dirección de memoria, no lo que dice literal.
        // Como Java optimiza memoria, si t1 y t2 dicen lo mismo, apuntan el mismo lado (String Pool)
        System.out.println("¿t1 == t2? " + (t1 == t2));      // Da true
        
        // Al usar new String, lo saca del pool y la caga, ahora == da false.
        System.out.println("¿t1 == obj? " + (t1 == obj));    // Da false
        
        // Por eso SIEMPRE comparar con equals()!
        System.out.println("¿t1.equals(obj)? " + t1.equals(obj)); // Da true
        
        // A menos que le metas .intern() y lo fuerces a volver al pool para comparar con ==
        String objInternado = obj.intern(); 
        System.out.println("¿t1 == obj.intern()? " + (t1 == objInternado)); // Da true
    }
}
