package chapter9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {
    @Test
    void testInsert() {
        BinarySearchTree tree = new BinarySearchTree(8);
        String[] inputs = {
                "insert 30",
                "insert 88",
                "insert 12",
                "insert 1",
                "insert 20",
                "insert 17",
                "insert 25",
                "buildResult",
        };

        StringBuilder result = new StringBuilder();
        result.append(" 1 12 17 20 25 30 88");
        result.append(System.lineSeparator());
        result.append(" 30 12 1 20 17 25 88");

        assertEquals(result.toString(), tree.createTree(inputs));
    }

    @Test
    void testFind() {
        BinarySearchTree tree = new BinarySearchTree(10);
        String[] inputs = {
                "insert 30",
                "insert 88",
                "insert 12",
                "insert 1",
                "insert 20",
                "find 12",
                "insert 17",
                "insert 25",
                "find 16",
                "buildResult",
        };

        StringBuilder result = new StringBuilder();
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("no");
        result.append(System.lineSeparator());
        result.append(" 1 12 17 20 25 30 88");
        result.append(System.lineSeparator());
        result.append(" 30 12 1 20 17 25 88");

        assertEquals(result.toString(), tree.createTree(inputs));
    }
}