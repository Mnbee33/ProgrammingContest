package chapter12;

public class Relation {
    int userId;
    int friendId;

    Relation(String line) {
        String[] inputs = line.split(" ");
        userId = Integer.parseInt(inputs[0]);
        friendId = Integer.parseInt(inputs[1]);
    }
}
