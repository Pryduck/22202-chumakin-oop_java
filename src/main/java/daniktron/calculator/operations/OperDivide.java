package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;
import daniktron.calculator.exceptions.StackCalcDivisionByZeroException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OperDivide extends DefaultStackOperation {
    public static final Logger logger = LoggerFactory.getLogger(OperDivide.class);

    public OperDivide() {
        super(1, 2);
    }

    @Override
    public void operate(CalcContext context, List<String> tokens) throws StackCalcDivisionByZeroException {
        float a = context.getStack().pop();
        float b = context.getStack().pop();
        if (b == 0) {
            logger.error("Command DIVIDE was not executed cause denominator = 0");
            throw new StackCalcDivisionByZeroException("Division by zero " + a + " / " + b);
        }
        context.getStack().push(a / b);
        //logger.info("Command DIVIDE was executed");
    }
}
