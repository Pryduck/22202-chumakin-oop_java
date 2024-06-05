package daniktron.calculator.exceptions;

public class StackCalcOperationsFileNotFound extends StackCalcException {
    public StackCalcOperationsFileNotFound() { super(); }
    public StackCalcOperationsFileNotFound(Exception e) { super(e); }
    public StackCalcOperationsFileNotFound(String e) { super(e); }
    public StackCalcOperationsFileNotFound(String s, Throwable cause) { super(s, cause); }
}
