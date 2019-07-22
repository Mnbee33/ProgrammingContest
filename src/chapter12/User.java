package chapter12;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> friendIds = new ArrayList<>();

    void addFriend(int id) {
        friendIds.add(id);
    }

    int queryForFriend(int index) {
        return friendIds.get(index);
    }

    int friendCount() {
        return friendIds.size();
    }
}
