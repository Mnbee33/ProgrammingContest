package chapter9;

import java.util.Objects;

public class Node {
    int key;
    Node parent;
    Node left;
    Node right;
    private static Node nil;

    public Node(int key) {
        this.key = key;
    }

    static Node from(int key) {
        Node node = new Node(key);
        node.parent = nil();
        node.right = nil();
        node.left = nil();
        return node;
    }

    static Node nil() {
        if (nil == null) {
            nil = new Node(-1);
            nil.parent = new Node(-1);
            nil.left = new Node(-1);
            nil.right = new Node(-1);
        }
        return nil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return key == node.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    boolean isEmpty() {
        return equals(nil());
    }

    boolean isSmaller(Node other) {
        return key < other.key;
    }

    void setChild(Node child) {
        if (child.isSmaller(this)) {
            left = child;
        } else {
            right = child;
        }
    }

    Node findParent(Node current) {
        Node parent = nil();
        while (!current.isEmpty()) {
            parent = current;
            current = getChild(current);
        }
        return parent;
    }

    private Node getChild(Node current) {
        return isSmaller(current) ? current.left : current.right;
    }
}
