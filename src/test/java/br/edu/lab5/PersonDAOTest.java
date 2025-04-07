package br.edu.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonDAOTest {

    @Test
    public void testNomeInvalido() {
        Person person = new Person(1, "Lucas", 25, Arrays.asList(new Email(1, "lucas@email.com")));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);
        Assertions.assertTrue(errors.contains("O nome deve ser composto por pelo menos 2 partes e conter apenas letras."));
    }

    @Test
    public void testIdadeInvalida() {
        Person person = new Person(1, "Lucas Silva", 0, Arrays.asList(new Email(1, "lucas@email.com")));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);
        Assertions.assertTrue(errors.contains("A idade deve estar no intervalo [1, 200]."));
    }

    @Test
    public void testSemEmails() {
        Person person = new Person(1, "Lucas Silva", 25, Collections.emptyList());
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);
        Assertions.assertTrue(errors.contains("A pessoa deve ter pelo menos um email associado."));
    }

    @Test
    public void testEmailInvalido() {
        Person person = new Person(1, "Lucas Silva", 25, Arrays.asList(new Email(1, "lucasemail.com")));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);
        Assertions.assertTrue(errors.contains("O email 'lucasemail.com' está em um formato inválido."));
    }

    @Test
    public void testPessoaValida() {
        Person person = new Person(1, "Lucas Silva", 25, Arrays.asList(new Email(1, "lucas@email.com")));
        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);
        Assertions.assertTrue(errors.isEmpty());
    }
}
