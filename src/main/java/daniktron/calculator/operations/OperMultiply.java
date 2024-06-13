package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.exceptions.StackCalcSintaxException;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OperMultiply extends DefaultStackOperation {
    public static final Logger logger = LoggerFactory.getLogger(OperMultiply.class);

    public OperMultiply() { super(1, 2); }
    @Override
    protected void operate(CalcContext context, List<String> tokens) throws StackCalcSintaxException {
        float a = context.getStack().pop();
        float b = context.getStack().pop();
        context.getStack().push(a * b);
        //logger.info("Command MULTIPLY was executed");
    }
}
