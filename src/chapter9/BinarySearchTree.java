package chapter9;

public class BinarySearchTree {
    int size;
    Node root = Node.nil();
    StringBuilder result = new StringBuilder();

    public BinarySearchTree(int n) {
        this.size = n;
    }

    public String createTree(String[] commandLines) {
        main(commandLines);
        return result.toString();
    }

    void main(String[] commandLines) {
        for (String line : commandLines) {
            Input input = Input.from(line);
            executeCommandUntilPrint(input);
        }
    }

    private void executeCommandUntilPrint(Input input) {
        switch (input.command) {
            case "insert":
                insert(input.key);
                break;
            case "findFromTree":
                Node found = root.findFromTree(input.key);
                setFoundResult(found);
                break;
            case "delete":
                delete(root.findFromTree(input.key));
                break;
            case "print":
                setTreeOrder();
            default:
                break;

        }
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

    private void setFoundResult(Node found) {
        result.append(found.isEmpty() ? "no" : "yes");
        result.append(System.lineSeparator());
    }

    void delete(Node node) {
        Node target = node.fixDeleteTarget();
        Node targetChild = target.getChildLeftFirst();

        target.setParent(targetChild);

        moveChild(target, targetChild);

        if (!target.equals(node)) {
            node.key = target.key;
        }
    }

    private void moveChild(Node target, Node targetChild) {
        if (target.parent.isEmpty()) {
            root = targetChild;
        } else {
            target.slideChild(targetChild);
        }
    }

    private void setTreeOrder() {
        setInorderToResult();
        setPreorderToResult();
    }

    private void setInorderToResult() {
        StringBuilder inorderKey = new StringBuilder();
        inorder(root, inorderKey);
        result.append(inorderKey);
        result.append(System.lineSeparator());
    }

    void inorder(Node u, StringBuilder inorderKey) {
        if (u.isEmpty()) return;
        inorder(u.left, inorderKey);
        inorderKey.append(" " + u.key);
        inorder(u.right, inorderKey);
    }

    private void setPreorderToResult() {
        StringBuilder preorderKey = new StringBuilder();
        preorder(root, preorderKey);
        result.append(preorderKey);
        result.append(System.lineSeparator());
    }

    void preorder(Node u, StringBuilder preorderKey) {
        if (u.isEmpty()) return;
        preorderKey.append(" " + u.key);
        preorder(u.left, preorderKey);
        preorder(u.right, preorderKey);
    }
}
