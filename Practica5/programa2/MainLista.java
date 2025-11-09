
/**
 * @file MainLista.java
 * @author Brayan Lucero Molina
 * @boleta 2024640465
 * @practica 5
 * @fecha 26 oct 2025
 * @descripcion Programa que crea una lista de alumnos con un profesor y muestra todos los datos
 */

import java.util.Scanner;

public class MainLista {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== CAPTURA DE DATOS DEL PROFESOR ===");
            System.out.print("Nombre completo: ");
            String nombreProfesor = sc.nextLine();
            System.out.print("Numero de empleado: ");
            String numEmpleado = sc.nextLine();
            
            Profesor profesor = new Profesor(nombreProfesor, numEmpleado);
            
            System.out.println("\n=== REGISTRO DE ALUMNOS ===");
            System.out.print("Cuantos alumnos desea registrar? ");
            int n = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            
            ListaAlumnos lista = new ListaAlumnos(profesor, n);
            
            for (int i = 0; i < n; i++) {
                System.out.println("\nAlumno " + (i + 1) + ":");
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido Paterno: ");
                String apP = sc.nextLine();
                System.out.print("Apellido Materno: ");
                String apM = sc.nextLine();
                System.out.print("Numero de Boleta: ");
                String boleta = sc.nextLine();
                System.out.print("Fecha de Nacimiento (dd/mm/aaaa): ");
                String fechaNac = sc.nextLine();
                System.out.print("Carrera: ");
                String carrera = sc.nextLine();
                System.out.print("Grupo: ");
                String grupo = sc.nextLine();
                System.out.print("Correo Electronico: ");
                String correo = sc.nextLine();
                
                Alumno alumno = new Alumno(nombre, apP, apM, boleta, fechaNac, carrera, grupo, correo);
                lista.agregarAlumno(alumno, i);
            }
            
            System.out.println("\n=== RESULTADOS ===\n");
            lista.mostrarLista();
        }
    }
}
