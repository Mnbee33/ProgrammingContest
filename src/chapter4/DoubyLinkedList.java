package chapter4;

public class DoubyLinkedList {
    MyNode nil;

    DoubyLinkedList() {
        nil = new MyNode("");
        nil.next = nil;
        nil.prev = nil;
    }

    void insert(MyNode node) {
        node.next = nil.next;
        nil.next.prev = node;
        nil.next = node;
        node.prev = nil;
    }


    MyNode get(String key) {
        MyNode current = nil.next;
        while (current != nil && !current.key.equals(key)) {
            current = current.next;
        }
        return current;
    }

    void deleteNode(MyNode node) {
        if (node == nil) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    void delete(String key) {
        deleteNode(get(key));
    }

    void deleteFirst() {
        deleteNode(nil.next);
    }

    void deleteLast() {
        deleteNode(nil.prev);
    }

    void parse(String line) {
        String[] commands = line.split(" ");
        switch (commands[0]) {
            case "insert":
                insert(new MyNode(commands[1]));
                break;
            case "delete":
                delete(commands[1]);
                break;
            case "deleteFirst":
                deleteFirst();
                break;
            case "deleteLast":
                deleteLast();
                break;
        }
    }

    void executeAll(String[] commands) {
        int size = Integer.valueOf(commands[0]);
        for (int i = 1; i <= size; i++) {
            parse(commands[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        MyNode node = nil.next;
        while (node != nil) {
            result.append(node);
            result.append(" ");
            node = node.next;
        }
        return result.toString().trim();
    }
}
