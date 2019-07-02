package chapter9;

import java.util.Set;
import java.util.TreeSet;

public class MyDictionary {
    int size;
    Set<String> dictionary = new TreeSet<>();
    StringBuilder foundResult = new StringBuilder();

    MyDictionary(int n) {
        size = n;
    }

    public String submitCommands(String[] commandLines) {
        for (int i = 0; i < size; i++) {
            executeCommand(commandLines[i]);
        }
        return foundResult.toString().trim();
    }

    void executeCommand(String line) {
        String[] inputs = line.split(" ");
        String command = inputs[0];
        String key = inputs[1];

        switch (command) {
            case "insert":
                dictionary.add(key);
                break;
            default:
                apendFoundResult(key);
        }
    }

    void apendFoundResult(String key) {
        foundResult.append(hadFound(key));
        foundResult.append(System.lineSeparator());
    }

    String hadFound(String key) {
        return dictionary.contains(key) ? "yes" : "no";
    }
}
