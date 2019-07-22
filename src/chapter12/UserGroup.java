package chapter12;

public class UserGroup {
    int[] group;

    static final int NIL = -1;

    UserGroup(int n) {
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = NIL;
        }
    }

    void addUser(int groupType, int userId) {
        group[userId] = groupType;
    }

    boolean isNotInAnyGroup(int userId) {
        return group[userId] == NIL;
    }

    String isConnected(Relation relation) {
        return group[relation.userId] == group[relation.friendId] ? "yes" : "no";
    }
}
