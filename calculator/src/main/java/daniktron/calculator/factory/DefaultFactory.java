package daniktron.calculator.factory;

import daniktron.calculator.DefaultStackOperation;
import daniktron.calculator.StackOperation;
import daniktron.calculator.exceptions.*;
import daniktron.calculator.factory.Factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//принимает файл, хранит словарь, связывающий строковое представление операции с объектом, который её реализует
public class DefaultFactory implements Factory {
    final private String fileName;
    final private Map<String, StackOperation> operationDict;
    public DefaultFactory(String name) throws StackCalcConfigException {
        this.fileName = name;
        this.operationDict = new HashMap<>();

        try (Scanner fileScanner = new Scanner(new FileReader(fileName))) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                if (!line.isEmpty()) {
                    String[] tokens = line.split(" ");
                    operationDict.put(
                        tokens[0],
                        Class.forName(tokens[1]).asSubclass(StackOperation.class).newInstance());
                }
            }
        } catch (FileNotFoundException e){
            throw new StackCalcConfigException("Config not found!", e);
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new StackCalcConfigException("Error while reading config!", e);
        }
    }
    public DefaultFactory() throws StackCalcConfigException { this("config.txt"); }

    //реализация интерфейса
    @Override
    public StackOperation getOperation(String name) throws StackCalcOperationNotFoundException {
        StackOperation op = this.operationDict.get(name);
        if (op == null) {
            throw new StackCalcOperationNotFoundException("Operation " + name + " not found!");
        }
        return op;
    }
}
