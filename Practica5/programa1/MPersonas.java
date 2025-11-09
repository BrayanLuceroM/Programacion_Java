/**
 * @file MPersonas.java
 * @author Brayan Lucero Molina
 * @boleta 2024640465
 * @practica 5
 * @fecha 26 oct 2025
 * @descripcion Programa que pide datos de 3 personas y los guarda en un arreglo de tipo Persona
 */

import java.util.Scanner;

public class MPersonas {
    public static void main(String[] args) {
        // Crear un arreglo de 3 objetos Persona
        try (Scanner sc = new Scanner(System.in)) {
            // Crear un arreglo de 3 objetos Persona
            Persona[] personas = new Persona[3];
            
            System.out.println("CAPTURA DE DATOS DE 3 PERSONAS\n");
            
            // Captura de datos
            for (int i = 0; i < 3; i++) {
                System.out.println("Persona " + (i + 1) + ":");
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                
                System.out.print("Edad: ");
                int edad = sc.nextInt();
                
                System.out.print("Estatura (en metros): ");
                double estatura = sc.nextDouble();
                sc.nextLine(); // limpiar buffer
                
                System.out.print("Telefono: ");
                String telefono = sc.nextLine();
                
                personas[i] = new Persona(nombre, edad, estatura, telefono);
                System.out.println();
            }
            
            // Mostrar resultados
            System.out.println("=== RESULTADOS ===\n");
            for (int i = 0; i < personas.length; i++) {
                personas[i].mostrarDatos(i + 1);
            }
        }
    }
}
