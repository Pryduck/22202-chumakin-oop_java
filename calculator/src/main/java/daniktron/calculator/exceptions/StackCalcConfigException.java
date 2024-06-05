package daniktron.calculator.exceptions;

public class StackCalcConfigException extends StackCalcException {

    public StackCalcConfigException() { super(); }
    public StackCalcConfigException(Exception e) { super(e); }
    public StackCalcConfigException(String e) { super(e); }
    //конструктор с описанием ошибки и того, что вызвало исключение
    public StackCalcConfigException(String s, Throwable cause) { super(s, cause); }
}
