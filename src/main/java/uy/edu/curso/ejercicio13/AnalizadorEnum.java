package uy.edu.curso.ejercicio13;

public class AnalizadorEnum {

    public static TipoCaracter clasificarCaracter(char c) {
        c = Character.toLowerCase(c);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return TipoCaracter.VOCAL;
        } else if (Character.isDigit(c)) {
            return TipoCaracter.DIGITO;
        } else if (Character.isWhitespace(c)) {
            return TipoCaracter.ESPECIO_BLANCO;
        } else if (Character.isLetter(c)) {
            return TipoCaracter.CONSONANTE;
        }
        return TipoCaracter.OTRO; // Puntuación y demas cosas raras caen aca
    }

    /*
     * Ventajas reales del Enum (por las que no usé un int o String plano):
     * 1. Queda mucho mas facil de leer de un vistazo. En vez de andar adivinando que significa
     *    "return 1" o "return 2", el "return VOCAL" salta a la vista y sabes qué devuelve.
     * 2. Evito que le pasen basura. Si la funcion pide TipoCaracter, el programador
     *    no le puede pasar otra cosa por error de tipeo.
     * 3. Sirven para hacer bucles si les pones variables internas.
     * 4. En los 'switch' viaja como piña, te ahorra el lío de poner los default y olvidarte casos.
     */
    public static void analizarTexto(String texto) {
        int v_vocales = 0, v_consonantes = 0, v_digitos = 0, v_espacios = 0, v_otros = 0;

        // Recorro el String desarmandolo a char
        for (char letraSola : texto.toCharArray()) {
            
            // Me fijo en donde cae y sumo 1 en el contador que toque (con el switch sobre Enum)
            TipoCaracter clasificacion = clasificarCaracter(letraSola);
            switch (clasificacion) {
                case VOCAL: v_vocales++; break;
                case CONSONANTE: v_consonantes++; break;
                case DIGITO: v_digitos++; break;
                case ESPECIO_BLANCO: v_espacios++; break;
                case OTRO: v_otros++; break;
            }
        }

        System.out.println("Viendo: " + texto);
        System.out.println("Las Vocales: " + v_vocales);
        System.out.println("Las Consonantes: " + v_consonantes);
        System.out.println("Los Números: " + v_digitos);
        System.out.println("Los Espacios: " + v_espacios);
        System.out.println("Otros símbolos locos: " + v_otros);
        
        System.out.println("\nTipos creados con el Enum iterados programaticamente:");
        // Uso la magia que te trae .values() de los enums para recorrerlo sin guardarlo en un Array
        for (TipoCaracter item : TipoCaracter.values()) {
            System.out.println(" -> " + item.name());
        }
    }

    public static void main(String[] args) {
        analizarTexto("¡Hola Java 17!");
    }
}
