
/**
 * @file Profesor.java
 * @author Brayan Lucero Molina
 * @boleta 2024640465
 * @practica 5
 * @fecha 26 oct 2025
 * @descripcion Clase Profesor con nombre completo y numero de empleado
 */

public class Profesor {
    String nombreCompleto;
    String numeroEmpleado;

    public Profesor(String nombreCompleto, String numeroEmpleado) {
        this.nombreCompleto = nombreCompleto;
        this.numeroEmpleado = numeroEmpleado;
    }

    public void mostrarDatos() {
        System.out.println("Profesor: " + nombreCompleto);
        System.out.println("No. Empleado: " + numeroEmpleado);
    }
}
