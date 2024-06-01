package daniktron.calculator;

import daniktron.calculator.exceptions.StackCalcConstParseException;
import daniktron.calculator.exceptions.StackCalcVariableNotDefinedException;

import java.util.Map;
//токен -> число, getVal  все операции с токенами
public class Variable {
    //строка, которая хар-ет переменную - имя переменной или значение
    private final String val;
    //предопределяет во время вызова конструктора - подана ли на вход строка или число
    private final boolean isConst;
    //вызывается, когда нужно получить численное значение переменной
    public float getVal(final Map<String, Float> dictionary) throws StackCalcVariableNotDefinedException, StackCalcConstParseException {
        if (isConst) {//строковое представление в реальное число
            return parse(val);
        }
        /*объект-обёртка над float*/Float f = dictionary.get(val);
        if (f == null) {
            throw new StackCalcVariableNotDefinedException("Variable " + val + "is not defined!");
        }
        return f;
    }
    //конструктор
    public Variable(final String val) {
        this.val = val;
        this.isConst = isConst(val);
    }

    public boolean getIfItIsConst() {
        return this.isConst;
    }
    public final String getName() { return this.val; }
    //проверка - число ли это (в конструкторе например её вызываем)
    public static boolean isConst(final String val) {
        char c = val.charAt(0); //получить символ с индексом ноль (как массив [0]
        return ('0' <= c) && (c <= '9');
    }

    public static float parse(final String val) throws StackCalcConstParseException {
        float f;
        try { //ловится ошибка во время парсинга
            f = Float.parseFloat(val);
        }
        catch (NumberFormatException e) {
            throw new StackCalcConstParseException("Error when parsing constant: val", e);
        }
        return f;
    }
}
