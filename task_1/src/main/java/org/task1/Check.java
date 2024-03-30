package org.task1;

public class Check {
    private final int number;
    private final char[] str;

    public char[] getStr() {
        return str;
    }

    public int getNumber() {
        return number;
    }

    public Check(int number) {
        this.number = number;

        String strNumb = Integer.toString(number);
        this.str = strNumb.toCharArray();
    }


    //функция проверки размера числа
    public boolean sizeCheck() {
        if ((number < 1000) || (number > 9999)) {
            return false;
        }
        return true;
    }


    //функция проверки разных цифр
    public boolean different() {
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i+1; j < str.length; j++) {
                if (str[i] == str[j])
                    return false;
            }
        }
        return true;
    }
}
