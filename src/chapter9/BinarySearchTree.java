package chapter9;

public class BinarySearchTree {
    int size;

    Node root = Node.nil();
    StringBuilder inorderKey = new StringBuilder();
    StringBuilder preorderKey = new StringBuilder();

    public BinarySearchTree(int n) {
        this.size = n;
    }

    public String createTree(String[] commandLines) {
        insertUntilPrintCommand(commandLines);
        return buildResult();
    }

    void insertUntilPrintCommand(String[] commandLines) {
        for (String line : commandLines) {
            String[] commands = line.split(" ");
            String command = commands[0];
            if (command.equals("insert")) {
                insert(Integer.valueOf(commands[1]));
            } else if (command.equals("buildResult")) {
                break;
            }
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
        inorder(root);
        preorder(root);
        result.append(inorderKey);
        result.append(System.lineSeparator());
        result.append(preorderKey);
        return result.toString();
    }
}
