package chapter12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConnectedComponents {
    static final int NIL = -1;

    int count;
    int[] group;
    FriendLink link;

    class FriendLink {
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

    class User {
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

    class Relation {
        Integer userId;
        Integer friendId;

        Relation(String line) {
            String[] inputs = line.split(" ");
            userId = Integer.parseInt(inputs[0]);
            friendId = Integer.parseInt(inputs[1]);
        }
    }

    ConnectedComponents(int n) {
        count = n;
        link = new FriendLink(n);
        group = new int[count];
        for (int i = 0; i < count; i++) {
            group[i] = NIL;
        }
    }

    void depthFirstSearch(int user, int groupType) {
        Stack<Integer> visitingUsers = new Stack<>();
        visitingUsers.push(user);
        while (!visitingUsers.isEmpty()) {
            int visitedUser = visitingUsers.pop();
            groupingFriends(groupType, visitingUsers, visitedUser);
        }
    }

    private void groupingFriends(int groupType, Stack<Integer> visitingUsers, int visitedUser) {
        for (int i = 0; i < link.friendCount(visitedUser); i++) {
            int friendId = link.queryForFriend(visitedUser, i);
            if (isNotInAnyGroup(friendId)) {
                group[friendId] = groupType;
                visitingUsers.push(friendId);
            }
        }
    }

    void groupingAll() {
        int groupType = 1;
        for (int userId = 0; userId < count; userId++) {
            if (isNotInAnyGroup(userId)) {
                group[userId] = groupType;
                depthFirstSearch(userId, groupType++);
            }
        }
    }

    private boolean isNotInAnyGroup(int i) {
        return group[i] == NIL;
    }

    void createLink(String[] lines) {
        for (String line : lines) {
            Relation relation = new Relation(line);
            link.mutualLink(relation);
        }
        groupingAll();
    }

    String areConnected(String[] questions) {
        StringBuilder result = new StringBuilder();

        for (String question : questions) {
            Relation relation = new Relation(question);
            result.append(isConnected(relation));
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    private String isConnected(Relation relation) {
        return group[relation.userId] == group[relation.friendId] ? "yes" : "no";
    }
}
