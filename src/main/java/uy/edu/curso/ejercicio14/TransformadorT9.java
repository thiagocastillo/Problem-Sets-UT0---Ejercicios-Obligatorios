package uy.edu.curso.ejercicio14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TransformadorT9 {

    // Diccionario para ir matcheando el mapa (con el formato Map normal de java)
    private static final Map<Character, String> tecladoT9 = new HashMap<>();

    // Esto de acá es un inicializador estático, se carga una sola vez y chau picho
    static {
        tecladoT9.put('a', "2"); tecladoT9.put('b', "22"); tecladoT9.put('c', "222");
        tecladoT9.put('d', "3"); tecladoT9.put('e', "33"); tecladoT9.put('f', "333");
        tecladoT9.put('g', "4"); tecladoT9.put('h', "44"); tecladoT9.put('i', "444");
        tecladoT9.put('j', "5"); tecladoT9.put('k', "55"); tecladoT9.put('l', "555");
        tecladoT9.put('m', "6"); tecladoT9.put('n', "66"); tecladoT9.put('o', "666");
        tecladoT9.put('p', "7"); tecladoT9.put('q', "77"); tecladoT9.put('r', "777"); tecladoT9.put('s', "7777");
        tecladoT9.put('t', "8"); tecladoT9.put('u', "88"); tecladoT9.put('v', "888");
        tecladoT9.put('w', "9"); tecladoT9.put('x', "99"); tecladoT9.put('y', "999"); tecladoT9.put('z', "9999");
        tecladoT9.put(' ', "0");
    }

    // Método 1: le pasas texto y te devuelve los numeritos del teclado clásico
    public String convertirAT9(String entradaText) {
        if (entradaText == null) return "";
        
        // Uso string builder en lugar del "+" como pedia un ej para no reventar la ram si paso un libro
        StringBuilder aDevolver = new StringBuilder();
        entradaText = entradaText.toLowerCase();
        
        for (int i = 0; i < entradaText.length(); i++) {
            char caracterX = entradaText.charAt(i);
            String numerosApretar = tecladoT9.get(caracterX);
            
            if (numerosApretar != null) {
                // Chequear duplicados contiguos (para no pegarlos y q parezca otra letra)
                if (aDevolver.length() > 0 && 
                    aDevolver.charAt(aDevolver.length() - 1) == numerosApretar.charAt(0)) {
                    aDevolver.append(" "); // Ponemos la famosa e insoportable "pausa" de cuando tipeabas rapido antes 😂
                }
                aDevolver.append(numerosApretar);
            }
        }
        return aDevolver.toString();
    }

    // Método 2: el de invertir y parsear
    public String convertirAT9Invertido(String normal) {
        if (normal == null) return "";
        // Lo invierto con la funcion que ya trae el StringBuilder (un exito!) y le aplico la converison del metodo 1
        String alReves = new StringBuilder(normal).reverse().toString();
        return convertirAT9(alReves);
    }

    // Método 3: leer txt, transformar T9 y escribir en otro doc. 
    public void transformarArchivo(String miRutaIn, String miRutaOut, boolean queresInvertido) throws IOException {
        try (BufferedReader lectorAux = new BufferedReader(new FileReader(miRutaIn));
             BufferedWriter queEscribe = new BufferedWriter(new FileWriter(miRutaOut))) {
            
            String renglonX;
            while ((renglonX = lectorAux.readLine()) != null) {
                // Operador ternario fachero
                String miStringT9 = queresInvertido ? convertirAT9Invertido(renglonX) : convertirAT9(renglonX);
                queEscribe.write(miStringT9);
                queEscribe.newLine();
            }
        }
    }
}
