package daniktron.calculator.exceptions;

public class StackCalcException extends Exception {

    public StackCalcException() { super(); }
    public StackCalcException(Exception e) { super(e); }
    public StackCalcException(String e) { super(e); }
    public StackCalcException(String s, Throwable cause) { super(s, cause); }
}

