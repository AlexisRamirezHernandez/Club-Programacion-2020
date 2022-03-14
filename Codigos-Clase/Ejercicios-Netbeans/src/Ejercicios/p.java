/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

/**
 *
 * @author lito_
 */
public class p {

    public static void main(String[] args) {
        int a = 3, b = 6, c = 4;
        int mayor = 0, menor = 0;
        if (a > b && b > c) {
            mayor = a;
            menor = c;
        } else if (b > c && c > a) {
            mayor = b;
            menor = a;
        } else if (c > a && a > b) {
            mayor = c;
            menor = b;
        } else if (a > c && c > b) {
            mayor = a;
            menor = b;
        } else if (b > a && a > c) {
            mayor = b;
            menor = c;
        } else {
            mayor = c;
            menor = a;
        }
        for (int i = menor; i <= mayor; i++) {
            System.out.print(i + " ");
        }
    }

}
