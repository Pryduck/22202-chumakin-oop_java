package daniktron.calculator.operations;

import daniktron.calculator.DefaultStackOperation;
import daniktron.calculator.CalcContext;
import daniktron.calculator.Variable;
import daniktron.calculator.exceptions.StackCalcSintaxException;
import daniktron.calculator.exceptions.StackCalcVariableExpected;

import java.util.List;

public class OperDefine extends DefaultStackOperation {

    public OperDefine() {
        super(3, 0);
    }

    @Override
    public void operate(CalcContext context, List<String> tokens) throws StackCalcSintaxException {
        if (Variable.isConst(tokens.get(1))) {
            throw new StackCalcVariableExpected("Expected variable, but " + tokens.get(1) + " found!");
        }
        DefaultStackOperation.checkIfVariableNameIsCorrect(tokens.get(1));
        context.getDictionary().put(tokens.get(1), new Variable(tokens.get(2)).getVal(context.getDictionary()));
    }
}
