package org.task1;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int cowNumb;
    public static int bullNumb;


    public static void main(String[] args) {
        //генерация подходящего по условиям числа.......................................................................
        Random random = new Random();

        int riddle = 0;
        String strRiddle;
        char[] arrRiddle;
        while (true) {
            riddle = random.nextInt(9000) + 1000;
            strRiddle = Integer.toString(riddle);
            arrRiddle = strRiddle.toCharArray();
            //проверка цифр числа
            if (Check.different(arrRiddle) == 1) {
                break;
            }
        }
        //..............................................................................................................
        System.out.println("Enter a number: ");
        Scanner console = new Scanner(System.in);

        do {
            //ввод подходящего числа
            int numb;
            String strNumb;
            char[] arrNumb;

            while (true) {
                numb = console.nextInt();
                strNumb = Integer.toString(numb);
                arrNumb = strNumb.toCharArray();
                if (Check.sizeCheck(numb) == 1) {
                    if (Check.different(arrNumb) == 1) {
                        break;
                    } else {
                        System.out.println("your number has the same digits, try again: ");
                    }
                }
            }

            BullsAndCowsContainer container = Compare.counting(arrNumb, arrRiddle);

            cowNumb = container.getCows();
            bullNumb = container.getBulls();

            System.out.printf("Number of cows: " +cowNumb+"\n");
            System.out.printf("Number of bulls: " +bullNumb+"\n");
            if (bullNumb < 4) System.out.println("Next attempt: ");


        } while (bullNumb < 4);
        System.out.println("You won!");
    }
}
