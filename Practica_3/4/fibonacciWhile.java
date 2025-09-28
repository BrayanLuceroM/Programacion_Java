/**
 * @file fibonacciWhile.java
 * @author Brayan Lucero Molina
 * @brief  Programa que solicite al usuario un numero n e imprima en pantalla la sucesion de
 * Fibonacci hasta el termino n, utilizando un ciclo while.
 * @version 0.1
 * @date 2025-09-25
 * 
 * @copyright Copyright (c) 2025
 * 
 */

import java.util.Scanner;

public class fibonacciWhile {
    public static void main(String[] args) {
        // pido el numero de elementos
        try (Scanner sc = new Scanner(System.in)) {
            // pido el numero de elementos
            System.out.print("Proporcione un numero: ");
            int n = sc.nextInt();
            int a = 0, b = 1; // primeros numeros
            int i = 1; // contador
            System.out.print("La sucesion de Fibonacci hasta " + n + " elementos es: ");
            while (i <= n) {
                int c = a + b;
                System.out.print(b + " ");
                a = b;
                b = c;
                i++;
            }
        }
    }
}
