/**
 * @file Alumno.java
 * @author Brayan Lucero Molina
 * @boleta 2024640465
 * @practica 5
 * @fecha 26 oct 2025
 * @descripcion Clase Alumno con los datos de un estudiante
 */

public class Alumno {
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String boleta;
    String fechaNacimiento;
    String carrera;
    String grupo;
    String correo;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno,
                  String boleta, String fechaNacimiento, String carrera, String grupo, String correo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.boleta = boleta;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
        this.grupo = grupo;
        this.correo = correo;
    }

    public void mostrarDatos(int numero) {
        System.out.println(numero + ". " + apellidoPaterno + " " + apellidoMaterno + ", " + nombre +
                           " - " + boleta + " - " + fechaNacimiento + " - " + carrera +
                           " - " + grupo + " - " + correo);
    }
}
