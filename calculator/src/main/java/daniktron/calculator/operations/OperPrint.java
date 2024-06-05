package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;

public class OperPrint extends DefaultStackOperation {

    public OperPrint() {
        super(1, 1);
    }
    @Override
    public void operate(CalcContext context, List<String> tokens) {
        System.out.println(context.getStack().peek());
    }
}
