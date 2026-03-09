package org.ies.tierno.apps;

import org.ies.tierno.exceptions.DivideByZeroException;
import org.ies.tierno.exceptions.EmptyListException;
import org.ies.tierno.exceptions.NullNumberInDivision;
import org.ies.tierno.exceptions.OptionOutOfMenuException;

public interface App {
    void run() throws DivideByZeroException, NullNumberInDivision, EmptyListException, OptionOutOfMenuException;
}
