package uy.edu.curso.ejercicio5;

import java.util.Objects;

public class Marcapasos {
    
    // Lo hacemos static asi ocupa solo 4 bytes compartidos entre todos
    private static int totalRegistrados = 0;

    // Elegí int (4 bytes) asumiendo que el ID va a ser un número grande,
    // total hay como mil millones de personas que pueden necesitar uno.
    private final int idDispositivo;
    
    // Le puse short (2 bytes) pensando que como mucho van a haber unos miles de fabricantes.
    private final short codigoFabricante;
    
    // Aca meter un byte (-128 a 127) iba a ser medio justo, un paciente
    // con taquicardia lo explota. Asi que va con short.
    private short pulsaciones;
    
    // La batería va del 0 al 100 asi que entra re bien en un byte.
    private byte bateria;

    public Marcapasos(int idDispositivo, short codigoFabricante, short pulsaciones, byte bateria) {
        this.idDispositivo = idDispositivo;
        this.codigoFabricante = codigoFabricante;
        this.pulsaciones = pulsaciones;
        this.bateria = bateria;
        totalRegistrados++;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public short getCodigoFabricante() {
        return codigoFabricante;
    }

    public short getLatidosPorMinuto() {
        return pulsaciones;
    }

    public void setLatidosPorMinuto(short pulsaciones) {
        if (pulsaciones >= 0) {
            this.pulsaciones = pulsaciones;
        }
    }

    public byte getNivelBateria() {
        return bateria;
    }

    public void setNivelBateria(byte bateria) {
        if (bateria >= 0 && bateria <= 100) {
            this.bateria = bateria;
        }
    }
    
    public static int getTotalInstancias() {
        return totalRegistrados;
    }

    @Override
    public String toString() {
        return "Marcapasos [ID=" + idDispositivo + ", Cód_Fab=" + codigoFabricante + 
               "] => Bat: " + bateria + "%, Ritmo: " + pulsaciones + " bpm";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Marcapasos elOtro = (Marcapasos) obj;
        
        // Son el mismo marcapasos unicamente si tienen el mismo ID y son de la misma marca
        return idDispositivo == elOtro.idDispositivo && codigoFabricante == elOtro.codigoFabricante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDispositivo, codigoFabricante);
    }

    public static void main(String[] args) {
        Marcapasos m1 = new Marcapasos(1001, (short) 42, (short) 75, (byte) 98);
        Marcapasos m2 = new Marcapasos(1001, (short) 42, (short) 80, (byte) 95);
        Marcapasos m3 = new Marcapasos(2005, (short) 10, (short) 60, (byte) 20);

        System.out.println(m1);
        System.out.println(m3);
        System.out.println("Total fabricados: " + Marcapasos.getTotalInstancias());
        
        System.out.println("¿El m1 es el mismo aparato que el m2? -> " + m1.equals(m2)); // Tienen el mismo ID y fabricante, asi que si
        System.out.println("¿Y el m1 es igual al m3? -> " + m1.equals(m3)); // Nada que ver
    }
}
