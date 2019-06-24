package chapter8;

public class Node {
    static final int NIL = -1;
    int id;
    int parent = NIL;
    int left = NIL;
    int right = NIL;
    int depth;

    public Node() {

    }

    public Node(int id) {
        this.id = id;
    }

    String getType() {
        if (parent == Node.NIL) {
            return "root, ";
        } else if (left == Node.NIL) {
            return "leaf, ";
        } else {
            return "internal node, ";
        }
    }

    boolean isRoot() {
        return parent == NIL;
    }

    @Override
    public String toString() {
        StringBuilder node = new StringBuilder();
        node.append("node " + id + ": ");
        node.append("parent = " + parent + ", ");
        node.append("depth = " + depth + ", ");
        node.append(getType());

        return node.toString();
    }

    public boolean isEmptyLeft() {
        return left == NIL;
    }

    public boolean isEmptyRight() {
        return right == NIL;
    }

    public boolean isEmptyParent() {
        return parent == NIL;
    }
}
