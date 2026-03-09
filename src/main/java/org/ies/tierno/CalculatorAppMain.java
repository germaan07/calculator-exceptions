package org.ies.tierno;

import org.ies.tierno.apps.CalculatorApp;
import org.ies.tierno.exceptions.DivideByZeroException;
import org.ies.tierno.exceptions.EmptyListException;
import org.ies.tierno.exceptions.NullNumberInDivision;
import org.ies.tierno.exceptions.OptionOutOfMenuException;

import java.util.Scanner;

public class CalculatorAppMain {
    public static void main(String[] args) throws DivideByZeroException, NullNumberInDivision, EmptyListException, OptionOutOfMenuException {
        Scanner scanner = new Scanner(System.in);
        CalculatorApp calculatorApp = new CalculatorApp(scanner);

        calculatorApp.run();
    }
}