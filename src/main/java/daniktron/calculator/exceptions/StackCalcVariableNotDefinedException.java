package daniktron.calculator.exceptions;

public class StackCalcVariableNotDefinedException extends StackCalcSintaxException {
    public StackCalcVariableNotDefinedException() { super(); }
    public StackCalcVariableNotDefinedException(Exception e) { super(e); }
    public StackCalcVariableNotDefinedException(String e) { super(e); }
    public StackCalcVariableNotDefinedException(String s, Throwable cause) { super(s, cause); }
}
