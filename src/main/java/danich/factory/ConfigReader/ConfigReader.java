package danich.factory.ConfigReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ConfigReader {
    private static final String path = "/config.txt";
    private final HashMap<String, Integer> data;
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);;

    public enum Settings {
        storageBodySize,
        storageMotorSize,
        storageAccessorySize,
        storageAutoSize,
        accessorySuppliers,
        workers,
        dealers,
        logSale
    }
    public ConfigReader() {

        data = new HashMap<>();
        loadConfig(path);
    }

    public Integer get(Settings name) {
        return data.getOrDefault(name.name(), null);
    }

    private void loadConfig(String src) {
        try (Scanner fileScanner = new Scanner(ConfigReader.class.getResourceAsStream(src))) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                if (!line.isEmpty()) {
                    String[] tokens = line.split(" ");
                    data.put(tokens[0], Integer.parseInt(tokens[1]));
                }
            }
        } catch (Exception e) {
            logger.error("cant parse config file");
            logger.error(e.getMessage());
            //throw new RuntimeException(e);
        }
    }
}
