package org.ies.tierno.apps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exceptions.OptionOutOfMenuException;
import org.ies.tierno.model.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    private void menu(Calculator calculator) throws OptionOutOfMenuException {
        var option = 0;

        do {
            printMenu();
            option = selectOption();

            if (option == 1){
                calculator.divide()
            }
        } while (option != 3);


    }
}
