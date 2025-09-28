/**
 * @file raizenesimaWhile.java
 * @author Brayan Lucero Molina
 * @brief  Programa que permita al usuario obtener la raiz enesima de un numero entero positivo
 * mayor a 0. Para esto, debera hacerlo con logaritmos, los cuales deberan ser calculados
 * utilizando un ciclo while.
 * @version 0.1
 * @date 2025-09-27
 * 
 * @copyright Copyright (c) 2025
 * 
 */

import java.util.Scanner;

public class raizenesimaWhile {
    public static void main(String[] args) {
        try (
        // pido el numero y la raiz
        Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingresa un numero positivo: ");
            double n = sc.nextDouble();
            System.out.print("Ingresa el valor de la raiz (m): ");
            int m = sc.nextInt();

            if (n <= 0) {
                System.out.println("El numero debe ser mayor a 0");
                return;
            }

            // calculo ln(n) con while
            double ln = 0;
            double base = (n - 1) / (n + 1);
            int k = 0;

            while (k <= 5000) {
                double termino = (1.0 / (2 * k + 1)) * Math.pow(base, 2 * k + 1);
                ln = ln + termino;
                k++;
            }

            ln = 2 * ln;

            // constante e
            double e = 2.71828182846;

            // aplico la formula de la raiz
            double resultado = Math.pow(e, (1.0 / m) * ln);

            System.out.println("Resultado: " + resultado);
        }
    }
}
