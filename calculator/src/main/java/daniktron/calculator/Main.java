package daniktron.calculator;

import daniktron.calculator.exceptions.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //передаёт путь до файла
    public static void main(String[] args) throws StackCalcException {

        if (args.length == 0) {
            try (Scanner stream = new Scanner(System.in)) {
                new Calculator(stream).work();
            }
        } else {
            try (FileReader reader = new FileReader(args[0]); Scanner stream = new Scanner(reader)) {
                new Calculator(stream).work();
            } catch (IOException e) {
                throw new StackCalcOperationsFileNotFound("File " + args[0] + "not found!", e);
            }
        }
    }
}