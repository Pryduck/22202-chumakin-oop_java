package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;

public class OperPop extends DefaultStackOperation {

    public OperPop() {
        super(1, 1);
    }
    @Override
    public void operate(CalcContext context, List<String> tokens) {
        context.getStack().pop();
    }
}
