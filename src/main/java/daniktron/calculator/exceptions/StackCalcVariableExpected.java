package daniktron.calculator.exceptions;

public class StackCalcVariableExpected extends StackCalcSintaxException {
    public StackCalcVariableExpected() { super(); }
    public StackCalcVariableExpected(Exception e) { super(e); }
    public StackCalcVariableExpected(String e) { super(e); }
    public StackCalcVariableExpected(String s, Throwable cause) { super(s, cause); }
}
