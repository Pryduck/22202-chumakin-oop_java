package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;

public class OperPlus extends DefaultStackOperation {

    public OperPlus() {
        super(1, 2);
    }
    @Override
    public void operate(CalcContext context, List<String> tokens) {
        float a = context.getStack().pop();
        float b = context.getStack().pop();
        context.getStack().push(a + b);
    }
}
