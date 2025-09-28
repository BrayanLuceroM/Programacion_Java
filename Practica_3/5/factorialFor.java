/**
 * @file factorialFor.java
 * @author Brayan Lucero Molina
 * @brief  Programa que solicite al usuario un numero e imprima en pantalla su factorial, uti-
*  lizando un ciclo for.
 * @version 0.1
 * @date 2025-09-25
 * 
 * @copyright Copyright (c) 2025
 * 
 */

import java.util.Scanner;

public class factorialFor {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Proporcione un numero: ");
            int numero = sc.nextInt();
            
            long factorial = 1;
            
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }
            
            System.out.println("El factorial de " + numero + " es : " + factorial);
        }
    }
}
