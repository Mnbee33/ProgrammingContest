package chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {
    @Test
    void testTree() {
        BinaryTree tree = new BinaryTree(9);
        String[] inputs = {
                "0 1 4",
                "1 2 3",
                "2 -1 -1",
                "3 -1 -1",
                "4 5 8",
                "5 6 7",
                "6 -1 -1",
                "7 -1 -1",
                "8 -1 -1",
        };

        StringBuilder result = new StringBuilder();
        result.append("node 0: parent = -1, sibling = -1, degree = 2, depth = 0, height = 3, root");
        result.append(System.lineSeparator());
        result.append("node 1: parent = 0, sibling = 4, degree = 2, depth = 1, height = 1, internal node");
        result.append(System.lineSeparator());
        result.append("node 2: parent = 1, sibling = 3, degree = 0, depth = 2, height = 0, leaf");
        result.append(System.lineSeparator());
        result.append("node 3: parent = 1, sibling = 2, degree = 0, depth = 2, height = 0, leaf");
        result.append(System.lineSeparator());
        result.append("node 4: parent = 0, sibling = 1, degree = 2, depth = 1, height = 2, internal node");
        result.append(System.lineSeparator());
        result.append("node 5: parent = 4, sibling = 8, degree = 2, depth = 2, height = 1, internal node");
        result.append(System.lineSeparator());
        result.append("node 6: parent = 5, sibling = 7, degree = 0, depth = 3, height = 0, leaf");
        result.append(System.lineSeparator());
        result.append("node 7: parent = 5, sibling = 6, degree = 0, depth = 3, height = 0, leaf");
        result.append(System.lineSeparator());
        result.append("node 8: parent = 4, sibling = 5, degree = 0, depth = 2, height = 0, leaf");

        assertEquals(result.toString(), tree.createTree(inputs));
    }
}
