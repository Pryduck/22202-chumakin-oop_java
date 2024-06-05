package daniktron.calculator.exceptions;

public class StackCalcSintaxException extends StackCalcException {
    public StackCalcSintaxException() { super(); }
    public StackCalcSintaxException(Exception e) { super(e); }
    public StackCalcSintaxException(String e) { super(e); }
    public StackCalcSintaxException(String s, Throwable cause) { super(s, cause); }
}
