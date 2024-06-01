package daniktron.calculator.operations;

import daniktron.calculator.*;
import daniktron.calculator.exceptions.StackCalcConstParseException;
import daniktron.calculator.exceptions.StackCalcVariableNotDefinedException;

import java.util.List;

public class OperPush extends DefaultStackOperation {

    public OperPush() {
        super(2, 0);
    }

    @Override
    public void operate(CalcContext context, List<String> tokens) throws StackCalcVariableNotDefinedException, StackCalcConstParseException {
        context.getStack().push(new Variable(tokens.get(1)).getVal(context.getDictionary()));
    }
}
