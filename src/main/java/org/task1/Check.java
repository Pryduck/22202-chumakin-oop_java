package org.task1;

public class Check {
    //функция проверки размера числа
    public static int sizeCheck(int numb) {
        if ((numb < 1000) || (numb > 9999)) {
            System.out.println("your number is out of range, try again: ");
            return 0;
        } else return 1;
    }


    //функция проверки разных цифр
    public static int different(char[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = i+1; j < c.length; j++) {
                if (c[i] == c[j])
                    return 0;
            }
        }
        return 1;
    }
}
