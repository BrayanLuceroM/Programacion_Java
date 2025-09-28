/**
 * @file factorialWhile.java
 * @author Brayan Lucero Molina
 * @brief  Programa que solicite al usuario un numero e imprima en pantalla su factorial, uti-
*  lizando un ciclo while.
 * @version 0.1
 * @date 2025-09-26
 * 
 * @copyright Copyright (c) 2025
 * 
 */

import java.util.Scanner;

public class factorialWhile {
    public static void main(String[] args) {
        try (
            // pido el numero al usuario
        Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingresa un numero: ");
            int n = sc.nextInt();

            int i = 1;
            int factorial = 1;

            // hago el factorial con while
            while (i <= n) {
                factorial = factorial * i;
                i++;
            }

            System.out.println("El factorial es: " + factorial);
        }
    }
}
