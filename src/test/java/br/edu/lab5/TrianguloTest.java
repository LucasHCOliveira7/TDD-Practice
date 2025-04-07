package br.edu.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrianguloTest {

    @ParameterizedTest
    @CsvSource({
        "3, 4, 5, Escaleno", // Triângulo escaleno válido
        "2, 2, 3, Isósceles", // Triângulo isósceles válido
        "3, 3, 3, Equilátero", // Triângulo equilátero válido
        "2, 2, 2, Equilátero", // Permutação 1
        "3, 2, 2, Isósceles", // Permutação 2
        "2, 3, 2, Isósceles", // Permutação 3
        "0, 4, 5, Não é um triângulo", // Um valor zero
        "-1, 4, 5, Não é um triângulo",
        "1, 2, 3, Não é um triângulo",
        "3, 1, 2, Não é um triângulo",
        "2, 3, 1, Não é um triângulo",
        "1, 1, 3, Não é um triângulo",
        "3, 1, 1, Não é um triângulo",
        "1, 3, 1, Não é um triângulo",
        "0, 0, 0, Não é um triângulo"
    })
    public void testDeterminarTipo(int lado1, int lado2, int lado3, String tipoEsperado) {
        String tipo = Triangulo.determinarTipo(lado1, lado2, lado3);
        Assertions.assertEquals(tipoEsperado, tipo);
    }
}