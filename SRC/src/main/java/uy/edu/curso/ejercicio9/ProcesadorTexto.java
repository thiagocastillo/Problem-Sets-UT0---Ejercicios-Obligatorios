package uy.edu.curso.ejercicio9;

import java.util.Collection;

/**
 * Ejercicio 9. Interfaz base para el procesamiento de texto.
 * Permite definir un contrato común que distintas clases pueden implementar de formas variadas.
 */
public interface ProcesadorTexto {
    int contarPalabras(String texto);
    
    // Sobrecarga exigida por el ejercicio 9
    int contarPalabras(String[] lineas);
    int contarPalabras(Collection<String> lineas);
}
