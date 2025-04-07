package br.edu.lab5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> emails;
}
