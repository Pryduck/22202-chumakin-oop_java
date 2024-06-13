package daniktron.calculator.operations;

import daniktron.calculator.*;
import daniktron.calculator.exceptions.StackCalcConstParseException;
import daniktron.calculator.exceptions.StackCalcVariableNotDefinedException;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OperPush extends DefaultStackOperation {
    public static final Logger logger = LoggerFactory.getLogger(OperPush.class);

    public OperPush() {
        super(2, 0);
    }

    @Override
    public void operate(CalcContext context, List<String> tokens) throws StackCalcVariableNotDefinedException, StackCalcConstParseException {
        context.getStack().push(new Variable(tokens.get(1)).getVal(context.getDictionary()));
        //logger.info("Command PUSH was executed");
    }
}
