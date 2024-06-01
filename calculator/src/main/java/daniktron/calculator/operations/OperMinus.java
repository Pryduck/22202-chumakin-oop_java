package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;

public class OperMinus extends DefaultStackOperation {

    public OperMinus() {
        super(1, 2);
    }

    @Override
    public void operate(CalcContext context, List<String> tokens) {
        float a = context.getStack().pop();
        float b = context.getStack().pop();
        context.getStack().push(a - b);
    }
}
