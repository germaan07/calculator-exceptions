package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exceptions.DivideByZeroException;
import org.ies.tierno.exceptions.EmptyListException;
import org.ies.tierno.exceptions.NullNumberInDivision;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Log4j
public class Calculator {

    public Double divide(Double divisor, Double denominator) throws DivideByZeroException, NullNumberInDivision {
        if (divisor != 0){
            return denominator/divisor;
        } else if (divisor == null || denominator == null){
            if (divisor == null){
                throw new NullNumberInDivision("El divisor no puede ser NULL", divisor);
            } else {
                throw new NullNumberInDivision("El denominador no puede ser NULL", denominator);
            }
        }
        throw new DivideByZeroException(divisor);
    }

    public Optional<Double> average(List<Double> numbers) throws DivideByZeroException, NullNumberInDivision, EmptyListException {
        if (!numbers.isEmpty()){
            return numbers.stream().reduce(Double::sum).map( sum  -> sum / numbers.size()) ;
        }
        throw new EmptyListException(numbers);
    }
}
