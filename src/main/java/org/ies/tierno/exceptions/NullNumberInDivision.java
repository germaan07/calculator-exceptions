package org.ies.tierno.exceptions;

public class NullNumberInDivision extends Exception {
  private final Double number;

  public NullNumberInDivision(Double number) {
    super("El número: " + number + " no puede ser NULL.");
    this.number = number;
  }

  public NullNumberInDivision(String message, Double number) {
    super(message);
    this.number = number;
  }
}
