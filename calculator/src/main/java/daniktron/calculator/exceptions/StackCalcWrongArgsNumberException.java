package daniktron.calculator.exceptions;

public class StackCalcWrongArgsNumberException extends StackCalcSintaxException {
    public StackCalcWrongArgsNumberException() { super(); }
    public StackCalcWrongArgsNumberException(Exception e) { super(e); }
    public StackCalcWrongArgsNumberException(String e) { super(e); }
    public StackCalcWrongArgsNumberException(String s, Throwable cause) { super(s, cause); }
}
