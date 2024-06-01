package daniktron.calculator.exceptions;

public class StackCalcTooShortStackSizeException extends StackCalcException {
    public StackCalcTooShortStackSizeException() { super(); }
    public StackCalcTooShortStackSizeException(Exception e) { super(e); }
    public StackCalcTooShortStackSizeException(String e) { super(e); }
    public StackCalcTooShortStackSizeException(String s, Throwable cause) { super(s, cause); }
}
