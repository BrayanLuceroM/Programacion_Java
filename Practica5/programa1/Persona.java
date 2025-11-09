/**
 * @file Persona.java
 * @author Brayan Lucero Molina
 * @boleta 2024640465
 * @practica 5
 * @fecha 26 oct 2025
 * @descripcion Clase Persona con atributos y metodo para mostrar datos
 */

public class Persona {

    // Atributos
    String nombre;
    int edad;
    double estatura;
    String telefono;

    // Constructor
    public Persona(String nombre, int edad, double estatura, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.telefono = telefono;
    }

    // Metodo para mostrar los datos de la persona
    public void mostrarDatos(int numeroPersona) {
        int anioNacimiento = 2025 - edad;
        System.out.println("Persona " + numeroPersona + ":");
        System.out.println("¡Hola!, mi nombre es " + nombre + ", tengo " + edad + " anios, naci en " 
                           + anioNacimiento + ", mido " + estatura + " metros y mi numero de contacto es " 
                           + telefono + " ¡Saludos!");
        System.out.println();
    }
}
