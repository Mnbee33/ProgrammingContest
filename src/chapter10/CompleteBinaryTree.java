package chapter10;

public class CompleteBinaryTree {
    int size;
    int[] tree;

    CompleteBinaryTree(int n) {
        size = n;
        tree = new int[size + 1];
    }

    public String create(String commandLine) {
        String[] keys = commandLine.split(" ");
        createTree(keys);
        return writeNodes();
    }

    void createTree(String[] keys) {
        for (int i = 1; i <= size; i++) {
            tree[i] = Integer.valueOf(keys[i - 1]);
        }
    }

    String writeNodes() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            writeANode(result, i);
        }
        return result.toString().trim();
    }

    private void writeANode(StringBuilder result, int i) {
        writeKey(result, i);
        writeParent(result, i);
        writeLeft(result, i);
        writeRight(result, i);
        result.append(System.lineSeparator());
    }

    private void writeKey(StringBuilder result, int i) {
        result.append("node " + i + ": key = " + tree[i] + ", ");
    }

    private void writeParent(StringBuilder result, int i) {
        if (parent((i)) >= 1) result.append("parent key = " + tree[parent(i)] + ", ");
    }

    private void writeLeft(StringBuilder result, int i) {
        if (left(i) <= size) result.append("left key = " + tree[left(i)] + ", ");
    }

    private void writeRight(StringBuilder result, int i) {
        if (right(i) <= size) result.append("right key = " + tree[right(i)] + ", ");
    }

    int parent(int i) {
        return i / 2;
    }

    int left(int i) {
        return 2 * i;
    }

    int right(int i) {
        return 2 * i + 1;
    }
}
