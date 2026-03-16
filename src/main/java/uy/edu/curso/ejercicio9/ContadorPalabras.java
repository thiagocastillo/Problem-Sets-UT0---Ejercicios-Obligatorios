package uy.edu.curso.ejercicio9;

import java.util.Collection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContadorPalabras implements ProcesadorTexto {
    
    // Dejo el constructor vacío por las dudas, aunque Java te lo hace solo.
    public ContadorPalabras() {
    }

    // Le meto el Override para que quede claro que viene de la interfaz
    @Override
    public int contarPalabras(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0; // Si viene vacío, cero palabras
        }
        // Lo parto por los espacios (el regex \\s+ me agarra hasta tabulaciones o si hay dobles espacios)
        return texto.trim().split("\\s+").length;
    }

    // Acá hago lo de sobrecarga
    @Override
    public int contarPalabras(String[] lineas) {
        int cuantasSuman = 0;
        if (lineas != null) {
            for (String frasita : lineas) {
                // Reuso la funcion de arriba para sumar
                cuantasSuman += contarPalabras(frasita);
            }
        }
        return cuantasSuman;
    }

    // Y lo mismo pero con alguna lista en vez de arreglo estático
    @Override
    public int contarPalabras(Collection<String> lineas) {
        int contadorLista = 0;
        if (lineas != null) {
            for (String parte : lineas) {
                contadorLista += contarPalabras(parte);
            }
        }
        return contadorLista;
    }

    // Para ver todo el análisis de una devuelvo este objeto nuevo que armé
    public ResultadoAnalisis analizarTextoCompleto(String texto) {
        if (texto == null) return new ResultadoAnalisis(0, 0, 0);
        int totalLineas = texto.split("\n").length;
        int txtPalabras = contarPalabras(texto);
        int letrasTotal = texto.length();
        return new ResultadoAnalisis(txtPalabras, letrasTotal, totalLineas);
    }
    
    // ==== COSAS DEL EJERCICIO 10 ==== //

    public String[] obtenerLineas(String miRuta) {
        List<String> renglones = new ArrayList<>();
        // Uso el try con recursos que te cierra el archivo solo después de leer 
        try (BufferedReader lector = new BufferedReader(new FileReader(miRuta))) {
            String textoLeido;
            while ((textoLeido = lector.readLine()) != null) {
                renglones.add(textoLeido);
            }
        } catch (IOException excepcion) {
            System.err.println("Che, fijate si está bien la ruta del txt porque tiró error: " + excepcion.getMessage());
        }
        // Convierto la lista de vuelata a Array para cumplir la firma
        return renglones.toArray(new String[0]);
    }

    public int contarPalabrasArchivo(String nombreTxt) {
        String[] lineasDelTxt = obtenerLineas(nombreTxt);
        return contarPalabras(lineasDelTxt);
    }

    // Este es usando arreglos puros (una tranza para chequear que no repita valores)
    public String[] palabrasComunesArreglos(String[] arrayUno, String[] arrayDos) {
        if (arrayUno == null || arrayDos == null) return new String[0];
        
        String[] provisorio = new String[Math.min(arrayUno.length, arrayDos.length)];
        int contador = 0;

        for (String p1 : arrayUno) {
            for (String p2 : arrayDos) {
                if (p1.equals(p2)) {
                    // Valido que no la haya guardado ya
                    boolean yaPaso = false;
                    for (int k = 0; k < contador; k++) {
                        if (provisorio[k].equals(p1)) {
                            yaPaso = true;
                            break;
                        }
                    }
                    if (!yaPaso) {
                        provisorio[contador++] = p1;
                    }
                }
            }
        }
        // Devuelvo cortando lo que sobró porque un array no se achica solo
        return Arrays.copyOf(provisorio, contador);
    }

    // Este es con HashSets de la librería util, mucho más limpio y rápido.
    public String[] palabrasComunesColecciones(String[] arrA, String[] arrB) {
        if (arrA == null || arrB == null) return new String[0];
        
        // Pongo el A en un Set así ya saco los duplicados por atrás (el HashSet hace el trabajo sucio)
        Set<String> A_seteado = new HashSet<>(Arrays.asList(arrA));
        Set<String> palabrasRepes = new HashSet<>();

        for (String buscada : arrB) {
            if (A_seteado.contains(buscada)) {
                palabrasRepes.add(buscada);
            }
        }
        return palabrasRepes.toArray(new String[0]);
    }
}
