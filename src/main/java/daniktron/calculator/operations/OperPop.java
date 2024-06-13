package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OperPop extends DefaultStackOperation {
    public static final Logger logger = LoggerFactory.getLogger(OperPop.class);

    public OperPop() {
        super(1, 1);
    }
    @Override
    public void operate(CalcContext context, List<String> tokens) {
        context.getStack().pop();
        //logger.info("Command POP was executed");
    }
}
