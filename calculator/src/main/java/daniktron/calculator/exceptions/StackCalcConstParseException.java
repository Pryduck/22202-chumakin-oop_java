package daniktron.calculator.exceptions;

public class StackCalcConstParseException extends StackCalcSintaxException {
    public StackCalcConstParseException() { super(); }
    public StackCalcConstParseException(Exception e) { super(e); }
    public StackCalcConstParseException(String e) { super(e); }
    public StackCalcConstParseException(String s, Throwable cause) { super(s, cause); }
}
