package daniktron.calculator.factory;

import daniktron.calculator.DefaultStackOperation;
import daniktron.calculator.StackOperation;
import daniktron.calculator.exceptions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface Factory {
    //Map<String, StackOperation> ReadConfig() throws StackCalcConfigException;
    StackOperation getOperation(String name) throws StackCalcConfigException, StackCalcOperationNotFoundException;
}
