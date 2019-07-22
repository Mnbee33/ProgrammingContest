package chapter12;

import java.util.Stack;

public class ConnectedComponents {
    int count;
    UserGroup userGroup;
    FriendLink link;

    ConnectedComponents(int n) {
        count = n;
        link = new FriendLink(count);
        userGroup = new UserGroup(count);
    }

    void createLink(String[] lines) {
        for (String line : lines) {
            link.mutualLink(new Relation(line));
        }
        groupingAll();
    }

    private void groupingAll() {
        int groupType = 1;
        for (int userId = 0; userId < count; userId++) {
            if (userGroup.isNotInAnyGroup(userId)) {
                userGroup.addUser(groupType, userId);
                depthFirstSearch(userId, groupType++);
            }
        }
    }

    private void depthFirstSearch(int user, int groupType) {
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
            if (userGroup.isNotInAnyGroup(friendId)) {
                userGroup.addUser(groupType, friendId);
                visitingUsers.push(friendId);
            }
        }
    }

    String areConnected(String[] questions) {
        StringBuilder result = new StringBuilder();
        for (String question : questions) {
            result.append(userGroup.isConnected(new Relation(question)));
            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
