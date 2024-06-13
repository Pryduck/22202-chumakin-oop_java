package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;
import daniktron.calculator.exceptions.StackCalcNegativeSqrtException;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OperSqrt extends DefaultStackOperation {
    public static final Logger logger = LoggerFactory.getLogger(OperSqrt.class);

    public OperSqrt() {
        super(1, 1);
    }

    @Override
    public void operate(CalcContext context, List<String> tokens) throws StackCalcNegativeSqrtException {
        float a = context.getStack().pop();
        if (a < 0) {
            logger.error("Command SQRT was not executed cause number < 0");
            throw new StackCalcNegativeSqrtException("Negative number in sqrt");
        }
        context.getStack().push((float)Math.sqrt(a));
    }
}
