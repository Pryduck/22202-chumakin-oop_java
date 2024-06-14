package daniktron.calculator;

import java.util.Map;
import java.util.Stack;
//то с чем будем работать
public class CalcContext {
    private Map<String, Float> dictionary;
    private Stack<Float> stack;
    public CalcContext(Stack<Float> stack, Map<String, Float> dictionary) {
        this.stack = stack;
        this.dictionary = dictionary;
    }

    public Map<String, Float> getDictionary() {
        return dictionary;
    }

    public Stack<Float> getStack() {
        return stack;
    }
}
