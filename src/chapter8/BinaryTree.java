package chapter8;

import java.util.Arrays;

public class BinaryTree {
    BinaryNode[] tree;
    int size;

    public BinaryTree(int n) {
        size = n;
        tree = new BinaryNode[size];
        for (int id = 0; id < size; id++) {
            tree[id] = new BinaryNode(id);
        }
    }

    public String createTree(String[] lines) {
        setNodes(lines);

        int root = getRoot();
        setDepth(root, 0);
        setHeight(root);

        return printAll();
    }

    void setNodes(String[] lines) {
        for (int i = 0; i < size; i++) {
            int[] inputs = convertToIntArray(lines[i]);
            setParentAndChildren(inputs, tree[i]);
        }
    }

    int[] convertToIntArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::valueOf).toArray();
    }

    void setParentAndChildren(int[] args, BinaryNode target) {
        int value = args[0];
        int left = args[1];
        int right = args[2];

        target.left = left;
        target.right = right;

        if (!target.isEmptyLeft()) tree[left].parent = value;
        if (!target.isEmptyRight()) tree[right].parent = value;
    }

    int getRoot() {
        int root = 0;
        for (int i = 0; i < size; i++) {
            if (tree[i].isEmptyParent()) root = i;
        }
        return root;
    }

    void setDepth(int id, int depth) {
        if (id == BinaryNode.NIL) return;

        BinaryNode target = tree[id];
        target.depth = depth;
        setDepth(target.left, depth + 1);
        setDepth(target.right, depth + 1);
    }

    int setHeight(int id) {
        BinaryNode target = tree[id];

        int leftHeight = 0;
        int rightHeight = 0;

        if (!target.isEmptyLeft()) leftHeight = setHeight(target.left) + 1;
        if (!target.isEmptyRight()) rightHeight = setHeight(target.right) + 1;

        target.height = Integer.max(leftHeight, rightHeight);
        return target.height;
    }

    String printAll() {
        StringBuilder nodes = new StringBuilder();

        for (int id = 0; id < size; id++) {
            BinaryNode node = tree[id];
            node.sibling = getSibling(node);
            nodes.append(node);
            nodes.append(System.lineSeparator());
        }

        return nodes.toString().trim();
    }

    int getSibling(BinaryNode target) {
        if (target.isEmptyParent()) return BinaryNode.NIL;

        BinaryNode parent = tree[target.parent];
        if (parent.left != target.id && !parent.isEmptyLeft()) return parent.left;
        if (parent.right != target.id && !parent.isEmptyRight()) return parent.right;

        return BinaryNode.NIL;
    }
}
