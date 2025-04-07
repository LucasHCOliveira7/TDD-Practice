package br.edu.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculadoraSalarioTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarCalculoSalario(String nome, String email, Double salarioBase, CargoEnum cargo, Double salarioEsperado) {
        Funcionario funcionario = new Funcionario(nome, email, salarioBase, cargo);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        Double salarioFinal = calculadora.calcular(funcionario);
        Assertions.assertEquals(salarioEsperado, salarioFinal);
    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                // Desenvolvedor
                Arguments.of("Dev 1", "dev1@email.com", 4000.0, CargoEnum.DESENVOLVEDOR, 3200.0),
                Arguments.of("Dev 2", "dev2@email.com", 2000.0, CargoEnum.DESENVOLVEDOR, 1800.0),
                // DBA
                Arguments.of("DBA 1", "dba1@email.com", 3000.0, CargoEnum.DBA, 2250.0),
                Arguments.of("DBA 2", "dba2@email.com", 1500.0, CargoEnum.DBA, 1275.0),
                // Testador
                Arguments.of("Testador 1", "test1@email.com", 2500.0, CargoEnum.TESTADOR, 1875.0),
                Arguments.of("Testador 2", "test2@email.com", 1000.0, CargoEnum.TESTADOR, 850.0),
                // Gerente
                Arguments.of("Gerente 1", "gerente1@email.com", 6000.0, CargoEnum.GERENTE, 4200.0),
                Arguments.of("Gerente 2", "gerente2@email.com", 4000.0, CargoEnum.GERENTE, 3200.0)
        );
    }
}
