package daniktron.calculator;

import daniktron.calculator.exceptions.StackCalcSintaxException;
import daniktron.calculator.exceptions.StackCalcTooShortStackSizeException;

import java.util.List;

public interface StackOperation {
    void operation(CalcContext context, final List<String> tokens) throws StackCalcSintaxException, StackCalcTooShortStackSizeException;
}
