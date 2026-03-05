package org.ies.tierno.exceptions;

import java.util.List;

public class EmptyListException extends Exception {
    private final List<Double> numbers;

    public EmptyListException(List<Double> numbers) {
        super("La lista de errores está vacía.");
        this.numbers = numbers;
    }
}
