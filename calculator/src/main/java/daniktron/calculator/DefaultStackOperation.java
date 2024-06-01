package daniktron.calculator;

import daniktron.calculator.exceptions.StackCalcIllegalVariableNameException;
import daniktron.calculator.exceptions.StackCalcSintaxException;
import daniktron.calculator.exceptions.StackCalcTooShortStackSizeException;
import daniktron.calculator.exceptions.StackCalcWrongArgsNumberException;

import java.util.List;
//реализация шаблона стековой операции
public abstract class DefaultStackOperation implements StackOperation {

    final int correctTokensCount, minStackSize;

    public DefaultStackOperation(int correctTokensCount, int minStackSize) {
        this.correctTokensCount = correctTokensCount;
        this.minStackSize = minStackSize;
    }

    @Override
    public void operation(CalcContext context, final List<String> tokens) throws StackCalcSintaxException, StackCalcTooShortStackSizeException {
        checkStackSize(context, this.minStackSize);
        checkArgsCount(tokens, this.correctTokensCount);
        this.operate(context, tokens);
    }

    //реализуют потомки (в operations)
    protected abstract void operate(CalcContext context, final List<String> tokens) throws StackCalcSintaxException;

    private static void checkArgsCount(final List<String> args, int correctCount) throws StackCalcWrongArgsNumberException {
        if (args.size() != correctCount) {
            throw new StackCalcWrongArgsNumberException();
        }
    }

    private static void checkStackSize(final CalcContext context, int minSize) throws StackCalcTooShortStackSizeException {
        if (context.getStack().size() < minSize) {
            throw new StackCalcTooShortStackSizeException();
        }
    }

    protected static void checkIfVariableNameIsCorrect(final String variableName) throws StackCalcIllegalVariableNameException {
        for (int i = 0; i < variableName.length(); ++i) {
            char c = variableName.charAt(i);
            if ((c < '0' || '9' < c) && (c < 'a' || 'z' < c) && (c < 'A' || 'Z' < c)) {
                throw new StackCalcIllegalVariableNameException("Variable name " + variableName + " is not correct variable name!");
            }
        }
    }
}
