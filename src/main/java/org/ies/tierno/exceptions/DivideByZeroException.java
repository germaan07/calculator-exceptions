package org.ies.tierno.exceptions;

public class DivideByZeroException extends Exception {
    private final Double divisor;

    public DivideByZeroException(Double denominator) {
        super("El denominador es igual a 0.");
        this.divisor = denominator;
    }
}
