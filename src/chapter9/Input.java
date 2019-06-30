package chapter9;

public class Input {
    String command;
    int key;

    static Input from(String line) {
        Input input = new Input();

        String[] commands = line.split(" ");
        input.command = commands[0];
        input.key = getKeyIfSet(commands);

        return input;
    }

    private static int getKeyIfSet(String[] commands) {
        return commands.length > 1 ? Integer.valueOf(commands[1]) : -1;
    }
}
