package org.task1;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        char[] arrRiddle = new Generation().getArrRiddle();

        System.out.println("Enter a number: ");
        Scanner console = new Scanner(System.in);

        int cowNumb = 0;
        int bullNumb = 0;

        do {
            //ввод подходящего числа
            int numb;
            //String strNumb;
            char[] arrNumb;

            while (true) {
                numb = console.nextInt();
                Check check = new Check(numb);

                if (check.sizeCheck()) {
                    if (check.different()) {
                        arrNumb = check.getStr();
                        break;
                    } else {
                        System.out.println("your number has the same digits, try again: ");
                    }
                }
                else {
                    System.out.println("your number is out of range, try again: ");
                }
            }

            BullsAndCowsContainer container = (new Compare()).counting(arrNumb, arrRiddle);

            cowNumb = container.getCows();
            bullNumb = container.getBulls();

            System.out.printf("Number of cows: " +cowNumb+"\n");
            System.out.printf("Number of bulls: " +bullNumb+"\n");
            if (bullNumb < 4) System.out.println("Next attempt: ");


        } while (bullNumb < 4);
        System.out.println("You won!");
    }
}
