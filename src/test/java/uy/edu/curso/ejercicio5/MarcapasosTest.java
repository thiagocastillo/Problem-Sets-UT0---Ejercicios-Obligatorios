package uy.edu.curso.ejercicio5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarcapasosTest {

    @Test
    void testCreacionYGetters() {
        Marcapasos m = new Marcapasos(1234, (short) 10, (short) 70, (byte) 90);
        
        assertEquals(1234, m.getIdDispositivo());
        assertEquals(10, m.getCodigoFabricante());
        assertEquals(70, m.getLatidosPorMinuto());
        assertEquals(90, m.getNivelBateria());
    }

    @Test
    void testSettersConValidacion() {
        Marcapasos m = new Marcapasos(1234, (short) 10, (short) 70, (byte) 90);
        
        // Asignaciones válidas
        m.setLatidosPorMinuto((short) 80);
        m.setNivelBateria((byte) 50);
        assertEquals(80, m.getLatidosPorMinuto());
        assertEquals(50, m.getNivelBateria());
        
        // Asignaciones inválidas (no deberían cambiar el estado actual)
        m.setLatidosPorMinuto((short) -5);
        m.setNivelBateria((byte) 105);
        m.setNivelBateria((byte) -1);
        
        assertEquals(80, m.getLatidosPorMinuto());
        assertEquals(50, m.getNivelBateria());
    }

    @Test
    void testIdentidadEqualsYHashcode() {
        Marcapasos m1 = new Marcapasos(1001, (short) 42, (short) 75, (byte) 98);
        Marcapasos m2 = new Marcapasos(1001, (short) 42, (short) 80, (byte) 95);
        Marcapasos m3 = new Marcapasos(2005, (short) 10, (short) 60, (byte) 20);

        // Son iguales si tienen el mismo idDispositivo y codigoFabricante
        assertEquals(m1, m2);
        assertEquals(m1.hashCode(), m2.hashCode());
        
        // Son distintos si difiere el id o el fabricante
        assertNotEquals(m1, m3);
        assertNotEquals(m1.hashCode(), m3.hashCode());
    }
}
