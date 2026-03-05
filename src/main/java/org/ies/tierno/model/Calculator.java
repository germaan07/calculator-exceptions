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
        return denominator/divisor;
    }

    public Optional<Double> average(List<Double> numbers) throws DivideByZeroException, NullNumberInDivision, EmptyListException {
        if (!numbers.isEmpty()){
            return numbers.stream().reduce(Double::sum).map( sum  -> sum / numbers.size()) ;
        }
        throw new EmptyListException(numbers);
    }
}
