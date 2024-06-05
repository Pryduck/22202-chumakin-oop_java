package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;
import daniktron.calculator.exceptions.StackCalcDivisionByZeroException;
import java.util.List;

public class OperDivide extends DefaultStackOperation {

    public OperDivide() {
        super(1, 2);
    }

    @Override
    public void operate(CalcContext context, List<String> tokens) throws StackCalcDivisionByZeroException {
        float a = context.getStack().pop();
        float b = context.getStack().pop();
        if (b == 0) {
            throw new StackCalcDivisionByZeroException("Division by zero " + a + " / " + b);
        }
        context.getStack().push(a / b);
    }
}
