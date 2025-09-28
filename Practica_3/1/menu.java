/**
 * @file menu.java
 * @author Brayan Lucero Molina
 * @brief Menu de figuras
 * @version 0.1
 * @date 2025-09-25
 * 
 * @copyright Copyright (c) 2025
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            
            do {
                limpiarPantalla();
                System.out.println("Calculadora de Areas y Perimetros");
                System.out.println("1. Circulo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Rectangulo");
                System.out.println("4. Triangulo equilatero");
                System.out.println("5. Trapecio");
                System.out.println("6. Paralelogramo");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = sc.nextInt();
                
                switch(opcion) {
                    case 1 -> calcularCirculo(sc);
                    case 2 -> calcularCuadrado(sc);
                    case 3 -> calcularRectangulo(sc);
                    case 4 -> calcularTriangulo(sc);
                    case 5 -> calcularTrapecio(sc);
                    case 6 -> calcularParalelogramo(sc);
                    case 7 -> System.out.println("Gracias por usar la calculadora de figuras");
                    default -> {
                        System.out.println("Opcion no valida");
                        esperarEnter(sc);
                    }
                }
            } while(opcion != 7);
        }
    }
    
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    // caso circulo
    public static void calcularCirculo(Scanner sc) {
        limpiarPantalla();
        System.out.println("Circulo");
        System.out.print("Proporcione el radio: ");
        double r = sc.nextDouble();
        double area = Math.PI * r * r;
        double perimetro = 2 * Math.PI * r;
        System.out.printf("El area es: %.2f\n", area);
        System.out.printf("El perimetro es: %.2f\n", perimetro);
        esperarEnter(sc);
    }
    
    // caso cuadrado
    public static void calcularCuadrado(Scanner sc) {
        limpiarPantalla();
        System.out.println("Cuadrado");
        System.out.print("Proporcione el lado: ");
        double lado = sc.nextDouble();
        double area = lado * lado;
        double perimetro = 4 * lado;
        System.out.printf("El area es: %.2f\n", area);
        System.out.printf("El perimetro es: %.2f\n", perimetro);
        esperarEnter(sc);
    }
    
    // caso rectangulo
    public static void calcularRectangulo(Scanner sc) {
        limpiarPantalla();
        System.out.println("Rectangulo");
        System.out.print("Proporcione la base: ");
        double base = sc.nextDouble();
        System.out.print("Proporcione la altura: ");
        double altura = sc.nextDouble();
        double area = base * altura;
        double perimetro = 2 * (base + altura);
        System.out.printf("El area es: %.2f\n", area);
        System.out.printf("El perimetro es: %.2f\n", perimetro);
        esperarEnter(sc);
    }
    
    // caso triangulo equilatero
    public static void calcularTriangulo(Scanner sc) {
        limpiarPantalla();
        System.out.println("Triangulo equilatero");
        System.out.print("Proporcione el lado: ");
        double lado = sc.nextDouble();
        double area = (Math.sqrt(3) / 4) * lado * lado;
        double perimetro = 3 * lado;
        System.out.printf("El area es: %.2f\n", area);
        System.out.printf("El perimetro es: %.2f\n", perimetro);
        esperarEnter(sc);
    }
    
    // caso trapecio
    public static void calcularTrapecio(Scanner sc) {
        limpiarPantalla();
        System.out.println("Trapecio");
        System.out.print("Proporcione la base mayor: ");
        double baseMayor = sc.nextDouble();
        System.out.print("Proporcione la base menor: ");
        double baseMenor = sc.nextDouble();
        System.out.print("Proporcione la altura: ");
        double altura = sc.nextDouble();
        System.out.print("Proporcione el lado 1: ");
        double lado1 = sc.nextDouble();
        System.out.print("Proporcione el lado 2: ");
        double lado2 = sc.nextDouble();
        double area = ((baseMayor + baseMenor) / 2) * altura;
        double perimetro = baseMayor + baseMenor + lado1 + lado2;
        System.out.printf("El area es: %.2f\n", area);
        System.out.printf("El perimetro es: %.2f\n", perimetro);
        esperarEnter(sc);
    }
    
    // caso paralelogramo
    public static void calcularParalelogramo(Scanner sc) {
        limpiarPantalla();
        System.out.println("Paralelogramo");
        System.out.print("Proporcione la base: ");
        double base = sc.nextDouble();
        System.out.print("Proporcione la altura: ");
        double altura = sc.nextDouble();
        System.out.print("Proporcione el lado: ");
        double lado = sc.nextDouble();
        double area = base * altura;
        double perimetro = 2 * (base + lado);
        System.out.printf("El area es: %.2f\n", area);
        System.out.printf("El perimetro es: %.2f\n", perimetro);
        esperarEnter(sc);
    }
    
    public static void esperarEnter(Scanner sc) {
        System.out.println("Presione ENTER para volver al Menu...");
        try {
            System.in.read();
        } catch(IOException e) {}
    }
}
