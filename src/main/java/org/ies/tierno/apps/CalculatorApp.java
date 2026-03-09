package org.ies.tierno.apps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exceptions.DivideByZeroException;
import org.ies.tierno.exceptions.EmptyListException;
import org.ies.tierno.exceptions.NullNumberInDivision;
import org.ies.tierno.exceptions.OptionOutOfMenuException;
import org.ies.tierno.model.Calculator;

import java.util.*;

@Data
@AllArgsConstructor
@Log4j
public class CalculatorApp implements App{
    Scanner scanner;
    public void run(){

    }

    private void printMenu(){
        log.info("  OPCIONES   ");
        log.info("1. Dividir.");
        log.info("2. Media.");
        log.info("3. Salir.");
    }

    private Integer selectOption() throws OptionOutOfMenuException{
        Integer option = null;
        do {
            try{
                log.info("Introduce la acción a realizar: ");
                option = scanner.nextInt();
                if (option > 3 || option < 1){
                    throw new OptionOutOfMenuException(option);
                }
            } catch (InputMismatchException e){
                log.error("Debe introducir un número.");
            } finally {
                scanner.nextLine();
            }
        } while (option == null);
        return option;
    }

    private void menu(Calculator calculator) throws OptionOutOfMenuException, DivideByZeroException, NullNumberInDivision, EmptyListException {
        var option = 0;

        do {
            printMenu();
            option = selectOption();

            if (option == 1){
                log.info("La división es: " + optionOne(calculator));
            } else if (option == 2){
                optionTwo(calculator);
            } else if (option != 3){
                log.error("La opción no está en el menú.");
            }
        } while (option != 3);
    }

    private double optionOne(Calculator calculator) throws DivideByZeroException, NullNumberInDivision{
        log.info("Introduce el DENOMINADOR");
        double denominator = scanner.nextDouble();
        scanner.nextLine();

        log.info("Introduce el DIVISOR: ");
        double divisor = scanner.nextInt();
        scanner.nextLine();

        Double division = null;
        do {
            try {
                division = calculator.divide(divisor, denominator);
            } catch (InputMismatchException e){
                log.error("Ningún número puede ser una letra.");
            } catch (DivideByZeroException e){
                log.error("El divisor no puede ser 0;");
            } finally {
                return division;
            }
        } while (division == null);
    }

    private Double getNumber(String message){
        Double number = null;
        do {
            try {
                if (message != null){
                    log.info(message);
                } else {
                    log.info("Introduce un número: ");
                }
                scanner.nextDouble();
            } catch (InputMismatchException e){
                log.error("El número no puede ser una letra.");
            } finally {
              scanner.nextLine();
            }
        } while (number == null);
        return number;
    }

    private List<Double> getList(){
        var size = getNumber("Introduce la cantidad de números que hay en la lista: ");
        List<Double> numbers = new ArrayList<>();
        for (int n = 0; n < size; n++) {
            numbers.add(getNumber(null));
        }
        return numbers;
    }

    private Optional<Double> optionTwo(Calculator calculator) throws DivideByZeroException, NullNumberInDivision, EmptyListException {
        return calculator.average(getList());
    }
}
