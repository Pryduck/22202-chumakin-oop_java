package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;

public class OperSqrt extends DefaultStackOperation {

    public OperSqrt() {
        super(1, 1);
    }

    @Override
    public void operate(CalcContext context, List<String> tokens) {
        context.getStack().push((float)Math.sqrt(context.getStack().pop()));
    }
}
