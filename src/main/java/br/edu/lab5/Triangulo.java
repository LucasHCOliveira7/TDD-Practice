package br.edu.lab5;

public class Triangulo {

    public static String determinarTipo(int lado1, int lado2, int lado3) {
        if (!ehTrianguloValido(lado1, lado2, lado3)) {
            return "Não é um triângulo";
        }

        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    private static boolean ehTrianguloValido(int lado1, int lado2, int lado3) {
        return lado1 > 0 && lado2 > 0 && lado3 > 0 &&
               lado1 + lado2 > lado3 &&
               lado1 + lado3 > lado2 &&
               lado2 + lado3 > lado1;
    }
}
