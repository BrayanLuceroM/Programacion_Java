/**
 * @file raizenesima.java
 * @author Brayan Lucero Molina
 * @brief  Programa que permita al usuario obtener la raiz enesima de un numero entero positivo
 * mayor a 0. Para esto, debera hacerlo con logaritmos, los cuales deberan ser calculados
 * utilizando un ciclo for.
 * @version 0.1
 * @date 2025-09-27
 * 
 * @copyright Copyright (c) 2025
 * 
 */


import java.util.Scanner;

public class raizenesima {
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

            // calculo ln(n) con la serie
            double ln = 0;
            // parte de la formula
            double base = (n - 1) / (n + 1);
            /*
            con 5000 iteraciones el ln(n) es muy preciso y la raiz sale casi exacta
            si uso menos iteraciones el ln(n) queda incompleto y el resultado es inpreciso
            por ejemplo con 1000 sigue bien algo bien pero con 100 ya hay una diferencia mas grande
            */

            for (int k = 0; k <= 5000; k++) {
                // sumo cada termino
                double termino = (1.0 / (2 * k + 1)) * Math.pow(base, 2 * k + 1);
                ln = ln + termino;
            }
            // multiplico al final
            ln = 2 * ln; 

            // constante e
            double e = 2.71828182846;

            // aplico la formula de la raiz
            double resultado = Math.pow(e, (1.0 / m) * ln);

            System.out.println("Resultado: " + resultado);
        }
    }
}
