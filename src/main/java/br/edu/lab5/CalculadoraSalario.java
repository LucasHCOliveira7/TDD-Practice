package br.edu.lab5;

public class CalculadoraSalario {

    public Double calcular(Funcionario funcionario) {
        if (funcionario.getCargo() == null || funcionario.getSalarioBase() == null) {
            return 0.0;
        }

        CargoEnum cargo = funcionario.getCargo();
        Double salarioBase = funcionario.getSalarioBase();

        if (salarioBase >= cargo.getLimite()) {
            return salarioBase * cargo.getTaxaSuperior();
        } else {
            return salarioBase * cargo.getTaxaInferior();
        }
    }
}
