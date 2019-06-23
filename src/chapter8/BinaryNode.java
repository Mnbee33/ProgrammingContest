package chapter8;

public class BinaryNode {
    static final int NIL = -1;

    int id;

    int parent = NIL;
    int left = NIL;
    int right = NIL;

    int depth;
    int height;

    int sibling;

    public BinaryNode(int i) {
        id = i;
    }


    boolean isEmptyRight() {
        return isEmpty(right);
    }

    boolean isEmptyLeft() {
        return isEmpty(left);
    }

    boolean isEmptyParent() {
        return isEmpty(parent);
    }

    boolean isEmpty(int node) {
        return node == NIL;
    }

    String getType() {
        if (isEmptyParent()) {
            return "root";
        } else if (isEmptyLeft() && isEmptyRight()) {
            return "leaf";
        } else {
            return "internal node";
        }
    }

    int getDegree() {
        int degree = 0;
        if (!isEmptyLeft()) degree++;
        if (!isEmptyRight()) degree++;
        return degree;
    }

    @Override
    public String toString() {
        return String.format("node %d: parent = %d, sibling = %d, degree = %d, depth = %d, height = %d, %s",
                id,
                parent,
                sibling,
                getDegree(),
                depth,
                height,
                getType());
    }
}
