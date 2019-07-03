package chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompleteBinaryTreeTest {
    @Test
    void testCreateTree() {
        CompleteBinaryTree tree = new CompleteBinaryTree(5);

        StringBuilder expected = new StringBuilder();
        expected.append("node 1: key = 7, left key = 8, right key = 1, ");
        expected.append(System.lineSeparator());
        expected.append("node 2: key = 8, parent key = 7, left key = 2, right key = 3, ");
        expected.append(System.lineSeparator());
        expected.append("node 3: key = 1, parent key = 7, ");
        expected.append(System.lineSeparator());
        expected.append("node 4: key = 2, parent key = 8, ");
        expected.append(System.lineSeparator());
        expected.append("node 5: key = 3, parent key = 8,");

        assertEquals(expected.toString(), tree.create("7 8 1 2 3"));
    }
}