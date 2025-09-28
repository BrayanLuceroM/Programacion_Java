/**
 * @file ecuacion.java
 * @author Brayan Lucero Molina
 * @brief Programa que calcule las ra ́ıces reales de una funci ́on cuadr ́atica ax2 + bx + c = 0
 * @version 0.1
 * @date 2025-09-25
 * 
 * @copyright Copyright (c) 2025
 * 
 */

import java.util.Scanner;

public class ecuacion {
    public static void main(String[] args) {
        // aqui pido los valores de la ecuacion
        try (Scanner sc = new Scanner(System.in)) {
            // aqui pido los valores de la ecuacion
            System.out.print("Proporcione el valor de a: ");
            double a = sc.nextDouble();
            System.out.print("Proporcione el valor de b: ");
            double b = sc.nextDouble();
            System.out.print("Proporcione el valor de c: ");
            double c = sc.nextDouble();
            
            // calculo el discriminante
            double D = (b * b) - (4 * a * c);
            
            if (D > 0) {
                // dos raices
                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                double x2 = (-b - Math.sqrt(D)) / (2 * a);
                System.out.println("La ecuacion tiene dos raices");
                System.out.printf("x1 = %.2f , x2 = %.2f\n", x1, x2);
            } else if (D == 0) {
                // una raiz
                double x = -b / (2 * a);
                System.out.println("La ecuacion tiene una raiz");
                System.out.printf("x = %.2f\n", x);
            } else {
                // sin raices reales
                System.out.println("La ecuacion no tiene raices reales");
            }
        }
    }
}
