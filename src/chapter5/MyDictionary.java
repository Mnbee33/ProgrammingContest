package chapter5;

public class MyDictionary {
    final int MAX_SIZE = 1046527;
    String[] data = new String[MAX_SIZE];

    int firstHash(int key, int m) {
        return key % m;
    }

    int secondHash(int key, int m) {
        return 1 + (key % (m - 1));
    }

    public int hash(int key, int m, int i) {
        return (firstHash(key, m) + i * secondHash(key, m)) % m;
    }

    int getChar(char ch) {
        switch (ch) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                return 0;
        }
    }

    int getKey(String str) {
        int sum = 0;
        int key = 1;
        for (int i = 0; i < str.length(); i++) {
            sum += key * (getChar(str.charAt(i)));
            key *= 5;
        }
        return sum;
    }

    public void insert(String str) {
        int key = getKey(str);
        addDictionary(str, key);
    }

    void addDictionary(String str, int key) {
        for (int i = 0; ; i++) {
            int hashKey = hash(key, MAX_SIZE, i);
            if (existsAlready(str, hashKey)) return;
            if (isThereNoData(hashKey)) {
                data[hashKey] = str;
                break;
            }
        }
    }

    private boolean isThereNoData(int key) {
        return data[key] == null;
    }

    private boolean existsAlready(String str, int key) {
        return str.equals(data[key]);
    }

    public boolean isFound(String str) {
        int key = getKey(str);
        return existInKey(str, key);
    }

    boolean existInKey(String str, int key) {
        for (int i = 0; ; i++) {
            int hashKey = hash(key, MAX_SIZE, i);
            if (existsAlready(str, hashKey)) {
                return true;
            } else if (isThereNoData(hashKey)) {
                return false;
            }
        }
    }

    public String command(String line) {
        String[] commands = line.split(" ");

        String command = commands[0];
        String value = commands[1];

        return executeCommand(command, value);
    }

    String executeCommand(String command, String value) {
        switch (command) {
            case "insert":
                insert(value);
                return "";
            case "find":
                String result = isFound(value) ? "yes" : "no";
                return result + System.lineSeparator();
            default:
                return null;
        }
    }

    public String commandAll(String[] input) {
        StringBuilder result = new StringBuilder();
        int size = Integer.valueOf(input[0]);
        for (int i = 1; i <= size; i++) {
            result.append(command(input[i]));
        }
        return result.toString().trim();
    }
}
