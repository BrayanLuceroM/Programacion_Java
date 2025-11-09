/**
 * @file ListaAlumnos.java
 * @author Brayan Lucero Molina
 * @boleta 2024640465
 * @practica 5
 * @fecha 26 oct 2025
 * @descripcion Clase que almacena y muestra la lista de alumnos
 */

public class ListaAlumnos {
    Alumno[] alumnos;
    Profesor profesor;
    int total;

    public ListaAlumnos(Profesor profesor, int total) {
        this.profesor = profesor;
        this.total = total;
        this.alumnos = new Alumno[total];
    }

    public void agregarAlumno(Alumno alumno, int posicion) {
        alumnos[posicion] = alumno;
    }

    public void mostrarLista() {
        profesor.mostrarDatos();
        System.out.println("================================");
        System.out.println("Lista de Alumnos Inscritos");
        System.out.println("================================");
        for (int i = 0; i < total; i++) {
            alumnos[i].mostrarDatos(i + 1);
        }
        System.out.println("================================");
        System.out.println("Total de alumnos inscritos: " + total);
    }
}
