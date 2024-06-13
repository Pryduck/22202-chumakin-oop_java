package daniktron.calculator;

import daniktron.calculator.exceptions.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    //передаёт путь до файла
    public static void main(String[] args) throws StackCalcException {

        if (args.length == 0) {
            logger.info("Calculator started reading from the console");
            try (Scanner stream = new Scanner(System.in)) {
                new Calculator(stream).work();
            }
        } else {
            logger.info("Calculator started reading from the file");
            try (FileReader reader = new FileReader(args[0]); Scanner stream = new Scanner(reader)) {
                new Calculator(stream).work();
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new StackCalcOperationsFileNotFound("File " + args[0] + "not found!", e);
            }
        }
    }
}