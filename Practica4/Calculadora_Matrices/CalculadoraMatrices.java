/**
 * @file menu.java
 * @author Brayan Lucero Molina
 * @brief Programa en Java que realiza operaciones con matrices cuadradas
 *        como suma, resta, producto punto, multiplicación, traspuesta e inversa (para 3x3).
 * @version 0.1
 * @date 2025-10-18
 * 
 * @copyright Copyright (c) 2025
 */

import java.util.Scanner;

public class CalculadoraMatrices {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;

    // Solicita el tamaño de las matrices cuadradas
    System.out.print("Ingresa el tamaño de las matrices n x n: ");
    n = sc.nextInt();

    // Declaración de matrices A y B
    double[][] A = new double[n][n];
    double[][] B = new double[n][n];

    // Lectura de los valores de la matriz A
    System.out.println("Ingresa los valores de la matriz A:");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print("A[" + i + "][" + j + "]: ");
            A[i][j] = sc.nextDouble();
        }
    }

    // Lectura de los valores de la matriz B
    System.out.println("Ingresa los valores de la matriz B:");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print("B[" + i + "][" + j + "]: ");
            B[i][j] = sc.nextDouble();
        }
    }

    int opcion;
    // Ciclo principal del menú
    do {
        System.out.println("\n==============================");
        System.out.println("     CALCULADORA DE MATRICES  ");
        System.out.println("==============================");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Producto punto (1ra fila A y 1ra columna B)");
        System.out.println("4. Multiplicación de matrices");
        System.out.println("5. Traspuesta de A");
        System.out.println("6. Traspuesta de B");
        System.out.println("7. Inversa de A (solo si 3x3)");
        System.out.println("8. Inversa de B (solo si 3x3)");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
        opcion = sc.nextInt();

        // Menú de operaciones
        switch (opcion) {

            case 1 -> {
                // SUMA de matrices A + B
                System.out.println("\nHas elegido SUMA de matrices.");
                double[][] suma = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        suma[i][j] = A[i][j] + B[i][j];
                    }
                }
                System.out.println("Resultado de A + B:");
                imprimirMatriz(suma);
                pausa(sc);
            }

            case 2 -> {
                // RESTA de matrices A - B
                System.out.println("\nHas elegido RESTA de matrices.");
                double[][] resta = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        resta[i][j] = A[i][j] - B[i][j];
                    }
                }
                System.out.println("Resultado de A - B:");
                imprimirMatriz(resta);
                pausa(sc);
            }

            case 3 -> {
                // PRODUCTO PUNTO entre primera fila de A y primera columna de B
                System.out.println("\nHas elegido PRODUCTO PUNTO.");
                double producto = 0;
                for (int i = 0; i < n; i++) {
                    producto += A[0][i] * B[i][0];
                }
                System.out.println("Resultado del producto punto: " + producto);
                pausa(sc);
            }

            case 4 -> {
                // MULTIPLICACIÓN de matrices A x B
                System.out.println("\nHas elegido MULTIPLICACIÓN de matrices.");
                double[][] mult = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            mult[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
                System.out.println("Resultado de A x B:");
                imprimirMatriz(mult);
                pausa(sc);
            }

            case 5 -> {
                // TRASPUESTA de la matriz A
                System.out.println("\nHas elegido la TRASPUESTA de A.");
                double[][] tA = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        tA[i][j] = A[j][i];
                    }
                }
                System.out.println("Traspuesta de A:");
                imprimirMatriz(tA);
                pausa(sc);
            }

            case 6 -> {
                // TRASPUESTA de la matriz B
                System.out.println("\nHas elegido la TRASPUESTA de B.");
                double[][] tB = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        tB[i][j] = B[j][i];
                    }
                }
                System.out.println("Traspuesta de B:");
                imprimirMatriz(tB);
                pausa(sc);
            }

            case 7 -> {
                // INVERSA de la matriz A (solo 3x3)
                System.out.println("\nHas elegido la INVERSA de A.");
                if (n == 3) {
                    double[][] invA = inversa3x3(A);
                    System.out.println("Inversa de A:");
                    imprimirMatriz(invA);
                } else {
                    System.out.println("Solo funciona con matrices de 3x3.");
                }
                pausa(sc);
            }

            case 8 -> {
                // INVERSA de la matriz B (solo 3x3)
                System.out.println("\nHas elegido la INVERSA de B.");
                if (n == 3) {
                    double[][] invB = inversa3x3(B);
                    System.out.println("Inversa de B:");
                    imprimirMatriz(invB);
                } else {
                    System.out.println("Solo funciona con matrices de 3x3.");
                }
                pausa(sc);
            }

            case 0 -> System.out.println("\nGracias por usar la calculadora de matrices.");

            default -> {
                // Validación de opción inválida
                System.out.println("\nOpción inválida, intenta de nuevo.");
                pausa(sc);
            }
        }

    } while (opcion != 0); // Fin del menú
}

/**
 * Imprime una matriz en formato tabular.
 * @param M matriz a imprimir
 */
public static void imprimirMatriz(double[][] M) {
    for (double[] fila : M) {
        for (int j = 0; j < M[0].length; j++) {
            System.out.print(fila[j] + "\t");
        }
        System.out.println();
    }
}

/**
 * Calcula la inversa de una matriz 3x3 utilizando la matriz adjunta y el determinante.
 * @param m matriz original 3x3
 * @return matriz inversa 3x3
 */
public static double[][] inversa3x3(double[][] m) {
    double det = determinante3x3(m);
    if (det == 0) {
        System.out.println("La matriz no tiene inversa");
        return new double[3][3];
    }
    double[][] inv = new double[3][3];
    inv[0][0] = (m[1][1]*m[2][2]-m[1][2]*m[2][1])/det;
    inv[0][1] = -(m[0][1]*m[2][2]-m[0][2]*m[2][1])/det;
    inv[0][2] = (m[0][1]*m[1][2]-m[0][2]*m[1][1])/det;
    inv[1][0] = -(m[1][0]*m[2][2]-m[1][2]*m[2][0])/det;
    inv[1][1] = (m[0][0]*m[2][2]-m[0][2]*m[2][0])/det;
    inv[1][2] = -(m[0][0]*m[1][2]-m[0][2]*m[1][0])/det;
    inv[2][0] = (m[1][0]*m[2][1]-m[1][1]*m[2][0])/det;
    inv[2][1] = -(m[0][0]*m[2][1]-m[0][1]*m[2][0])/det;
    inv[2][2] = (m[0][0]*m[1][1]-m[0][1]*m[1][0])/det;
    return inv;
}

/**
 * Calcula el determinante de una matriz 3x3.
 * @param m matriz 3x3
 * @return determinante de la matriz
 */
public static double determinante3x3(double[][] m) {
    return m[0][0]*(m[1][1]*m[2][2]-m[1][2]*m[2][1])
         - m[0][1]*(m[1][0]*m[2][2]-m[1][2]*m[2][0])
         + m[0][2]*(m[1][0]*m[2][1]-m[1][1]*m[2][0]);
}

/**
 * Pausa la ejecución hasta que el usuario presione Enter.
 * @param sc objeto Scanner para leer la entrada
 */
public static void pausa(Scanner sc) {
    System.out.println("\nPresiona Enter para continuar...");
    sc.nextLine();
    sc.nextLine();
}

}
