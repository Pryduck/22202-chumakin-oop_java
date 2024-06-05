package daniktron.calculator;

import daniktron.calculator.exceptions.*;
import daniktron.calculator.factory.DefaultFactory;
import daniktron.calculator.factory.Factory;

import java.util.*;

public class Calculator {
    //фактори переведёт строку в операцию
    private Factory factory;
    private CalcContext context = new CalcContext(new Stack<>(), new HashMap<>());
    private Scanner stream;
    private boolean hasNext = true;

    //public boolean hasNext() { return this.hasNext; }

    public final CalcContext getContext() { return this.context; }

    public Calculator(Scanner stream) throws StackCalcConfigException { this(stream, new DefaultFactory()); }

    public Calculator(Scanner stream, Factory factory) {
        this.stream = stream;
        this.factory = factory;
    }

    /*public Calculator(Scanner stream, String fileName) throws StackCalcConfigException {
        this(stream, new DefaultFactory(fileName));
    }*/

    public void work() throws StackCalcException {
        do {
            step();
        } while (hasNext);
    }

    public boolean step() throws StackCalcException {
        hasNext = stream.hasNext(); //находит и считывает след. строку
        if (!hasNext) {
            return false;
        }
        while (true) {
            String line = stream.nextLine();

            if (line.isEmpty() || line.charAt(0) == '#') {
                hasNext = stream.hasNext();
                if (!hasNext)
                    return false;
                continue;
            }

            String[] tokens = line.split(" ");

            if (tokens[0].equals("EXIT")) {
                hasNext = false;
                return false;
            }
            //первый арг-т передаётся на factory и он возвр-ет операцию
            StackOperation s = factory.getOperation(tokens[0]);
            //вызов операции с контекстом и токенами
            s.operation(context, Arrays.asList(tokens)/*List.of(tokens)*/);
            //s.operation(context, Arrays.stream(tokens).collect(Collectors.toList()));
            hasNext = stream.hasNext();

            return hasNext;
        }
    }
}
