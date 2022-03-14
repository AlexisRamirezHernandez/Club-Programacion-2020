/*
 *
 * Programa que calcula si un numero es primo o no.
 */
package Ejercicios;

/**
 *
 * @author 
 */
public class Primos {

    public static void main(String[] args) {
        int n = 9;
        int contador = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                contador++;
            }
        }
        if (contador == 2) {
            System.out.println(n + " Es primo");
        } else {
            System.out.println(n + " No es primo");

        }
    }
}
