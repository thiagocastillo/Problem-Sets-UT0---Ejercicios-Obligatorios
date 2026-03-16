package uy.edu.curso.ejercicio9;

/**
 * Clase para devolver múltiples datos como resultado de un análisis.
 */
public class ResultadoAnalisis {
    private final int cantPalabras;
    private final int cantCaracteres;
    private final int cantLineas;

    public ResultadoAnalisis(int cantPalabras, int cantCaracteres, int cantLineas) {
        this.cantPalabras = cantPalabras;
        this.cantCaracteres = cantCaracteres;
        this.cantLineas = cantLineas;
    }

    public int getCantPalabras() { return cantPalabras; }
    public int getCantCaracteres() { return cantCaracteres; }
    public int getCantLineas() { return cantLineas; }

    @Override
    public String toString() {
        return String.format("Análisis -> Palabras: %d, Caracteres: %d, Líneas: %d", 
                             cantPalabras, cantCaracteres, cantLineas);
    }
}
