package org.task1;
import java.util.Random;

public class Generation {
    private int riddle;

    private char[] arrRiddle;

    Generation() {
        Random random = new Random();
        while (true) {
            riddle = random.nextInt(9000) + 1000;
            Check check = new Check(riddle);
            //проверка цифр числа
            if (check.different()) {
                this.arrRiddle = check.getStr();
                break;
            }
        }
    }

    public char[] getArrRiddle() {
        return arrRiddle;
    }
    public int getRiddle() {
        return riddle;
    }
}
