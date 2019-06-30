package chapter9;

public class BinarySearchTree {
    int size;

    Node root = Node.nil();
    StringBuilder foundResult = new StringBuilder();
    StringBuilder inorderKey = new StringBuilder();
    StringBuilder preorderKey = new StringBuilder();

    public BinarySearchTree(int n) {
        this.size = n;
    }

    public String createTree(String[] commandLines) {
        main(commandLines);
        return buildResult();
    }

    void main(String[] commandLines) {
        for (String line : commandLines) {
            Input input = Input.from(line);
            if (executeCommandUntilPrint(input)) break;
        }
    }

    private boolean executeCommandUntilPrint(Input input) {
        switch (input.command) {
            case "insert":
                insert(input.key);
                break;
            case "find":
                Node found = find(root, input.key);
                setFoundResult(found);
                break;
            case "print":
                return true;
        }
        return false;
    }

    void insert(int key) {
        Node target = Node.from(key);

        Node parent = target.findParent(root);
        target.parent = parent;

        if (parent.isEmpty()) {
            root = target;
        } else {
            parent.setChild(target);
        }
    }

    Node find(Node u, int key) {
        while (!u.isEmpty() && key != u.key) {
            if (key < u.key) {
                u = u.left;
            } else {
                u = u.right;
            }
        }
        return u;
    }

    private void setFoundResult(Node found) {
        foundResult.append(found.isEmpty() ? "no" : "yes");
        foundResult.append(System.lineSeparator());
    }

    void inorder(Node u) {
        if (u.isEmpty()) return;
        inorder(u.left);
        inorderKey.append(" " + u.key);
        inorder(u.right);
    }

    void preorder(Node u) {
        if (u.isEmpty()) return;
        preorderKey.append(" " + u.key);
        preorder(u.left);
        preorder(u.right);
    }

    String buildResult() {
        StringBuilder result = new StringBuilder();
        buildFindResult(result);
        buildTreeOrder(result);
        return result.toString();
    }

    private void buildFindResult(StringBuilder result) {
        result.append(foundResult);
    }

    private void buildTreeOrder(StringBuilder result) {
        inorder(root);
        preorder(root);
        result.append(inorderKey);
        result.append(System.lineSeparator());
        result.append(preorderKey);
    }
}
