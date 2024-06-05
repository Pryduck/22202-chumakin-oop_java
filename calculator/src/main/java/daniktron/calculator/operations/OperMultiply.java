package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.exceptions.StackCalcSintaxException;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;

public class OperMultiply extends DefaultStackOperation {
    public OperMultiply() { super(1, 2); }
    @Override
    protected void operate(CalcContext context, List<String> tokens) throws StackCalcSintaxException {
        float a = context.getStack().pop();
        float b = context.getStack().pop();
        context.getStack().push(a * b);
    }
}
