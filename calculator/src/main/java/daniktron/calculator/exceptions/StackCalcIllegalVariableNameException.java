package daniktron.calculator.exceptions;

public class StackCalcIllegalVariableNameException extends StackCalcSintaxException {
    public StackCalcIllegalVariableNameException() { super(); }
    public StackCalcIllegalVariableNameException(Exception e) { super(e); }
    public StackCalcIllegalVariableNameException(String e) { super(e); }
    public StackCalcIllegalVariableNameException(String s, Throwable cause) { super(s, cause); }
}
