package uy.edu.curso.ejercicio9;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ContadorPalabrasTest {

    @Test
    void testContarPalabrasString() {
        ContadorPalabras cp = new ContadorPalabras();
        assertEquals(4, cp.contarPalabras("Hola  mundo desde Java"));
        assertEquals(0, cp.contarPalabras("   "));
        assertEquals(0, cp.contarPalabras((String) null));
    }

    @Test
    void testContarPalabrasArregloYColeccion() {
        ContadorPalabras cp = new ContadorPalabras();
        String[] lineas = {"Hola mundo", "Java 17", "   "};
        List<String> lista = Arrays.asList(lineas);
        
        assertEquals(4, cp.contarPalabras(lineas));
        assertEquals(4, cp.contarPalabras((java.util.Collection<String>) lista));
    }

    @Test
    void testAnalizarTextoCompleto() {
        ContadorPalabras cp = new ContadorPalabras();
        ResultadoAnalisis res = cp.analizarTextoCompleto("Hola\nmundo");
        
        assertEquals(2, res.getCantPalabras());
        assertEquals(10, res.getCantCaracteres());
        assertEquals(2, res.getCantLineas());
    }

    @Test
    void testInterseccionArreglos() {
        ContadorPalabras cp = new ContadorPalabras();
        String[] a = {"uno", "dos", "tres", "cuatro"};
        String[] b = {"tres", "cuatro", "cinco"};
        
        String[] comunes = cp.palabrasComunesArreglos(a, b);
        assertEquals(2, comunes.length);
        assertTrue(Arrays.asList(comunes).contains("tres"));
        assertTrue(Arrays.asList(comunes).contains("cuatro"));
    }

    @Test
    void testInterseccionColecciones() {
        ContadorPalabras cp = new ContadorPalabras();
        String[] a = {"uno", "dos", "dos", "tres"}; // Prueba duplicados
        String[] b = {"dos", "cuatro", "tres", "tres"};
        
        String[] comunes = cp.palabrasComunesColecciones(a, b);
        // Debe haber 2 (dos y tres) evitando repetidos
        assertEquals(2, comunes.length);
        List<String> comunesList = Arrays.asList(comunes);
        assertTrue(comunesList.contains("dos"));
        assertTrue(comunesList.contains("tres"));
    }

    @Test
    void testManejoArchivosTemporal() throws IOException {
        // Creamos un archivo temporal para la prueba
        File temp = File.createTempFile("test_contador", ".txt");
        temp.deleteOnExit();

        try (FileWriter writer = new FileWriter(temp)) {
            writer.write("Linea 1 de prueba\nLinea numero 2");
        }

        ContadorPalabras cp = new ContadorPalabras();
        String[] leidas = cp.obtenerLineas(temp.getAbsolutePath());
        
        assertEquals(2, leidas.length);
        assertEquals("Linea 1 de prueba", leidas[0]);
        
        int palabras = cp.contarPalabrasArchivo(temp.getAbsolutePath());
        assertEquals(7, palabras); // 4 en linea 1 + 3 en linea 2
    }
}
