package chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RootedTreeTest {

    @Test
    void testTree() {
        RootedTree tree = new RootedTree(13);

        String[] inputs = {
                "0 3 1 4 10",
                "1 2 2 3",
                "2 0",
                "3 0",
                "4 3 5 6 7",
                "5 0",
                "6 0",
                "7 2 8 9",
                "8 0",
                "9 0",
                "10 2 11 12",
                "11 0",
                "12 0",
        };

        StringBuilder result = new StringBuilder();
        result.append("node 0: parent = -1, depth = 0, root, [1, 4, 10]");
        result.append(System.lineSeparator());
        result.append("node 1: parent = 0, depth = 1, internal node, [2, 3]");
        result.append(System.lineSeparator());
        result.append("node 2: parent = 1, depth = 2, leaf, []");
        result.append(System.lineSeparator());
        result.append("node 3: parent = 1, depth = 2, leaf, []");
        result.append(System.lineSeparator());
        result.append("node 4: parent = 0, depth = 1, internal node, [5, 6, 7]");
        result.append(System.lineSeparator());
        result.append("node 5: parent = 4, depth = 2, leaf, []");
        result.append(System.lineSeparator());
        result.append("node 6: parent = 4, depth = 2, leaf, []");
        result.append(System.lineSeparator());
        result.append("node 7: parent = 4, depth = 2, internal node, [8, 9]");
        result.append(System.lineSeparator());
        result.append("node 8: parent = 7, depth = 3, leaf, []");
        result.append(System.lineSeparator());
        result.append("node 9: parent = 7, depth = 3, leaf, []");
        result.append(System.lineSeparator());
        result.append("node 10: parent = 0, depth = 1, internal node, [11, 12]");
        result.append(System.lineSeparator());
        result.append("node 11: parent = 10, depth = 2, leaf, []");
        result.append(System.lineSeparator());
        result.append("node 12: parent = 10, depth = 2, leaf, []");

        assertEquals(result.toString(), tree.createTree(inputs));
    }

}