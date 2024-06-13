package daniktron.calculator.operations;

import daniktron.calculator.CalcContext;
import daniktron.calculator.DefaultStackOperation;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OperPrint extends DefaultStackOperation {
    public static final Logger logger = LoggerFactory.getLogger(OperPrint.class);

    public OperPrint() {
        super(1, 1);
    }
    @Override
    public void operate(CalcContext context, List<String> tokens) {
        System.out.println(context.getStack().peek());
        //logger.info("Command PRINT was executed");
    }
}
