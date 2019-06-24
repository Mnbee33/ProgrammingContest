package chapter8;

import java.util.stream.Stream;

public class Treewalk {
    int size;
    Node[] tree;

    StringBuilder preorderNodes;
    StringBuilder inorderNodes;
    StringBuilder postorderNodes;

    public Treewalk(int n) {
        size = n;

        tree = new Node[size];
        for (int i = 0; i < size; i++) {
            tree[i] = new Node(i);
        }

        preorderNodes = new StringBuilder();
        inorderNodes = new StringBuilder();
        postorderNodes = new StringBuilder();
    }


    public String createTreeAndWalk(String[] lines) {
        setNodes(lines);
        return walkAll(getRoot());
    }

    void setNodes(String[] lines) {
        for (int i = 0; i < size; i++) {
            int[] inputs = convertToIntArray(lines[i]);
            setParentAndChildren(inputs, tree[i]);
        }
    }

    int[] convertToIntArray(String line) {
        return Stream.of(line.split(" "))
                .mapToInt(Integer::valueOf).toArray();
    }

    void setParentAndChildren(int[] args, Node target) {
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
        for (Node node : tree) {
            if (node.isEmptyParent()) root = node.id;
        }
        return root;
    }

    String walkAll(int root) {
        preorder(root);
        inorder(root);
        postorder(root);

        return buildResult();
    }

    void preorder(int id) {
        if (isEmptyNode(id)) return;

        preorderNodes.append(" " + id);
        preorder(tree[id].left);
        preorder(tree[id].right);
    }

    void inorder(int id) {
        if (isEmptyNode(id)) return;

        inorder(tree[id].left);
        inorderNodes.append(" " + id);
        inorder(tree[id].right);
    }

    void postorder(int id) {
        if (isEmptyNode(id)) return;
        postorder(tree[id].left);
        postorder(tree[id].right);
        postorderNodes.append(" " + id);
    }

    private boolean isEmptyNode(int id) {
        return id == Node.NIL;
    }

    String buildResult() {
        StringBuilder result = new StringBuilder();

        result.append("Preorder" + System.lineSeparator());
        result.append(preorderNodes);
        result.append(System.lineSeparator());

        result.append("Inorder" + System.lineSeparator());
        result.append(inorderNodes);
        result.append(System.lineSeparator());

        result.append("Postorder" + System.lineSeparator());
        result.append(postorderNodes);
        return result.toString();
    }
}
