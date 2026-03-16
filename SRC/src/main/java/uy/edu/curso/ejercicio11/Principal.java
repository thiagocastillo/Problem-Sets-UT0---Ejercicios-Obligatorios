package uy.edu.curso.ejercicio11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    // Función A: leer desde archivo
    public static void leerEntradaArchivo(String pathTxt) {
        System.out.println("== Intentando leer desde archivo .txt ==");
        File docTexto = new File(pathTxt);
        
        // Uso try con corchetes así Java cierra el Scanner solito y no tengo memory leaks
        try (Scanner lec = new Scanner(docTexto)) {
            
            // Me armé esto pensando que el txt va a venir así:
            // linea 1: entero
            // linea 2: double
            // linea 3: texto random
            
            if (lec.hasNextInt()) {
                int n1 = lec.nextInt();
                System.out.println("Entero leido del doc: " + n1);
                
                if (lec.hasNextDouble()) {
                    double numDouble = lec.nextDouble();
                    System.out.println("Real leido del doc: " + numDouble);
                    
                    // Nos morfamos el enter (salto de linea) escondido para no romper la proxima linea
                    lec.nextLine();
                    
                    if (lec.hasNextLine()) {
                        String cad = lec.nextLine();
                        System.out.println("La cadena de texto final fue -> " + cad);
                    }
                    
                    System.out.println("Si los sumo: " + (n1 + numDouble));
                    System.out.println("Dividiendo sobre 2 en entero: " + (n1 / 2));
                    System.out.println("Lo que me sobra de dividir: " + (n1 % 2));
                }
            }
        } catch (FileNotFoundException miErrorArchivo) {
            System.err.println("No encontré nada perro. Fijate la ruta: " + pathTxt);
        } catch (InputMismatchException errorFormato) {
            System.err.println("Che el txt trae letras en los números, no puedo parsearlo.");
        }
    }

    // Parte B: usar Stdin (la clásica consola)
    public static void leerEntradaStdin() {
        System.out.println("\n== Calculadora de circunferencias por consola ==");
        Scanner deConsola = new Scanner(System.in);
        System.out.print("Tirame un Radio para el circulo: ");
        
        try {
            // Cuidado aca que la consola te pide la coma o punto dependiendo tu sistema!
            double r = deConsola.nextDouble();
            if (r < 0) {
                System.out.println("El radio de un circulo no puede ser negativo, le erraste.");
            } else {
                double a = Math.PI * Math.pow(r, 2); // pi * r al cuadrado
                double peri = 2 * Math.PI * r; 
                
                // Muestro limitando los decimales asi no queda fiero
                System.out.printf("El área te dió: %.4f%n", a);
                System.out.printf("Y de perímetro metiste: %.4f%n", peri);
            }
        } catch (InputMismatchException errorInput) {
            System.err.println("Me pusiste un texto en vez de un número. Ojo que si estás con Windows en español tal vez va con coma.");
        } finally {
            // Cerramos de frente mar para el garbage collector
            deConsola.close();
        }
    }

    public static void main(String[] args) {
        String miDocParaEj11 = "datos_ejercicio11.txt";
        
        // Dejo comentada la de archivos asi corro solo consola, si queres descomendá
        // leerEntradaArchivo(miDocParaEj11);
        
        leerEntradaStdin();
    }
}
