package daniktron.calculator.exceptions;

public class StackCalcOperationNotFoundException extends StackCalcSintaxException {
    public StackCalcOperationNotFoundException() { super(); }
    public StackCalcOperationNotFoundException(Exception e) { super(e); }
    public StackCalcOperationNotFoundException(String e) { super(e); }
    public StackCalcOperationNotFoundException(String s, Throwable cause) { super(s, cause); }
}
