package org.task1;

public class Compare {
    //функция сравнения двух чисел
    public BullsAndCowsContainer counting(char[] c1, char[] c2) {
        int bullNumb = 0;
        int cowNumb = 0;
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    if (i == j) {
                        bullNumb++;
                    } else {
                        cowNumb++;
                    }
                    break;
                }
            }
        }
        return new BullsAndCowsContainer(bullNumb, cowNumb);
    }
}
