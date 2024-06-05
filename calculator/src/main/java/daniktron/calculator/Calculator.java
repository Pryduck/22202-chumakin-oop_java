package daniktron.calculator;

import daniktron.calculator.exceptions.*;
import daniktron.calculator.factory.DefaultFactory;
import daniktron.calculator.factory.Factory;

import java.util.*;

public class Calculator {

    private Factory factory;
    private CalcContext context = new CalcContext(new Stack<>(), new HashMap<>());
    private Scanner stream;
    private boolean hasNext = true;

    public final CalcContext getContext() { return this.context; }

    public Calculator(Scanner stream) throws StackCalcConfigException { this(stream, new DefaultFactory()); }

    public Calculator(Scanner stream, Factory factory) throws StackCalcConfigException {
        this.stream = stream;
        this.factory = factory;
    }

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
            s.operation(context, List.of(tokens));

            hasNext = stream.hasNext();

            return hasNext;
        }
    }
}
