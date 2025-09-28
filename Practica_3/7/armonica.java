/**
 * @file factorial.java
 * @author Brayan Lucero Molina
 * @brief  Programa que solicite al usuario un numero n e imprima n terminos de la serie
 * armonica y su suma hasta tres decimales, utilizando un ciclo for.
 * @version 0.1
 * @date 2025-09-26
 * 
 * @copyright Copyright (c) 2025
 * 
 */

import java.util.Scanner;

public class armonica {
    public static void main(String[] args) {
        try (// pido el numero de terminos
        Scanner sc = new Scanner(System.in)) {
            System.out.print("Proporcione el numero de terminos: ");
            int n = sc.nextInt();

            double suma = 0;

            System.out.print("Serie : ");
            for (int i = 1; i <= n; i++) {
                // voy sumando el valor
                suma = suma + (1.0 / i);

                if (i < n) {
                    System.out.print("1/" + i + " + ");
                } else {
                    System.out.print("1/" + i);
                }
            }

            // muestro la suma con tres decimales
            System.out.println();
            System.out.printf("Suma de los primeros " + n + " terminos : %.3f%n", suma);
        }
    }
}
