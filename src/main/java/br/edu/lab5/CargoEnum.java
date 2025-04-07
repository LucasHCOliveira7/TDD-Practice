package br.edu.lab5;

import lombok.Getter;

@Getter
public enum CargoEnum {
    DESENVOLVEDOR(3000.0, 0.8, 0.9),
    DBA(2000.0, 0.75, 0.85),
    TESTADOR(2000.0, 0.75, 0.85),
    GERENTE(5000.0, 0.7, 0.8);

    private final Double limite;
    private final Double taxaSuperior;
    private final Double taxaInferior;

    CargoEnum(Double limite, Double taxaSuperior, Double taxaInferior) {
        this.limite = limite;
        this.taxaSuperior = taxaSuperior;
        this.taxaInferior = taxaInferior;
    }
}
