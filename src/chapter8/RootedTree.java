package chapter8;

import java.util.Arrays;

public class RootedTree {
    Node[] tree;
    int size;

    RootedTree(int n) {
        size = n;
        tree = new Node[size];
        for (int i = 0; i < size; i++) {
            tree[i] = new Node();
        }
    }

    public String createTree(String[] lines) {
        for (String line : lines) {
            convertToNode(line);
        }

        int root = getRoot();
        setDepthRecursively(root, 0);

        return printAll();
    }

    void convertToNode(String line) {
        int[] args = convertToIntArgs(line);
        createNode(args);
    }

    private int[] convertToIntArgs(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private void createNode(int[] args) {
        int value = args[0];
        int degree = args[1];
        tree[value].id = value;

        int left = 0;
        for (int i = 0; i < degree; i++) {
            int child = args[i + 2];
            if (i == 0) {
                tree[value].left = child;
            } else {
                tree[left].right = child;
            }
            left = child;
            tree[child].parent = value;
        }
    }

    int getRoot() {
        int root = 0;
        for (int i = 0; i < size; i++) {
            if (tree[i].isRoot()) root = i;
        }
        return root;
    }

    void setDepthRecursively(int id, int parent) {
        tree[id].depth = parent;
        if (isEmptyNode(tree[id].right)) setDepthRecursively(tree[id].right, parent);
        if (isEmptyNode(tree[id].left)) setDepthRecursively(tree[id].left, parent + 1);
    }

    String printAll() {
        StringBuilder result = new StringBuilder();
        for (Node node : tree) {
            result.append(print(node));
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    String print(Node target) {
        StringBuilder node = new StringBuilder();
        node.append(target);
        setChildren(target, node);
        return node.toString();
    }

    void setChildren(Node target, StringBuilder node) {
        node.append("[");

        int children = target.left;
        boolean isFirst = true;
        while (isEmptyNode(children)) {
            if (isFirst) {
                isFirst = false;
            } else {
                node.append(", ");
            }
            node.append(children);
            children = tree[children].right;
        }

        node.append("]");

    }

    private boolean isEmptyNode(int children) {
        return children != Node.NIL;
    }
}
