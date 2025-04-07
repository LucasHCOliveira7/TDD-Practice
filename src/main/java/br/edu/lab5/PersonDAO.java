package br.edu.lab5;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<String> isValidToInclude(Person person) {
        List<String> errors = new ArrayList<>();

        // Valida se o nome tem pelo menos 2 partes e é composto apenas por letras
        if (person.getName() == null || !person.getName().matches("^[a-zA-Z]+(\\s[a-zA-Z]+)+$")) {
            errors.add("O nome deve ser composto por pelo menos 2 partes e conter apenas letras.");
        }

        // Valida se a idade está no intervalo [1, 200]
        if (person.getAge() < 1 || person.getAge() > 200) {
            errors.add("A idade deve estar no intervalo [1, 200].");
        }

        // Valida se há pelo menos um email associado
        if (person.getEmails() == null || person.getEmails().isEmpty()) {
            errors.add("A pessoa deve ter pelo menos um email associado.");
        } else {
            // Valida o formato dos emails
            for (Email email : person.getEmails()) {
                if (!email.getName().matches("^[^@]+@[^@]+\\.[^@]+$")) {
                    errors.add("O email '" + email.getName() + "' está em um formato inválido.");
                }
            }
        }

        return errors;
    }
}
