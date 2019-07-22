package chapter12;

import java.util.ArrayList;
import java.util.List;

public class FriendLink {
    List<User> link = new ArrayList<>();

    FriendLink(int size) {
        for (int i = 0; i < size; i++) {
            link.add(new User());
        }
    }

    void mutualLink(int userId, int friendId) {
        link(userId, friendId);
        link(friendId, userId);
    }

    void mutualLink(Relation relation) {
        mutualLink(relation.userId, relation.friendId);
    }

    private void link(int userId, int friendId) {
        User user = link.get(userId);
        user.addFriend(friendId);
    }

    int queryForFriend(int userId, int index) {
        return link.get(userId).queryForFriend(index);
    }

    int friendCount(int userId) {
        return link.get(userId).friendCount();
    }
}

