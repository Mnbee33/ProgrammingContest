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
                "print",
        };

        StringBuilder result = new StringBuilder();
        result.append(" 1 12 17 20 25 30 88");
        result.append(System.lineSeparator());
        result.append(" 30 12 1 20 17 25 88");
        result.append(System.lineSeparator());

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
                "findFromTree 12",
                "insert 17",
                "insert 25",
                "findFromTree 16",
                "print",
        };

        StringBuilder result = new StringBuilder();
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("no");
        result.append(System.lineSeparator());
        result.append(" 1 12 17 20 25 30 88");
        result.append(System.lineSeparator());
        result.append(" 30 12 1 20 17 25 88");
        result.append(System.lineSeparator());

        assertEquals(result.toString(), tree.createTree(inputs));
    }

    @Test
    void testDelete() {
        BinarySearchTree tree = new BinarySearchTree(18);
        String[] inputs = {
                "insert 8",
                "insert 2",
                "insert 3",
                "insert 7",
                "insert 22",
                "insert 1",
                "findFromTree 1",
                "findFromTree 2",
                "findFromTree 3",
                "findFromTree 4",
                "findFromTree 5",
                "findFromTree 6",
                "findFromTree 7",
                "findFromTree 8",
                "print",
                "delete 3",
                "delete 7",
                "print",
        };

        StringBuilder result = new StringBuilder();
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("no");
        result.append(System.lineSeparator());
        result.append("no");
        result.append(System.lineSeparator());
        result.append("no");
        result.append(System.lineSeparator());
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("yes");
        result.append(System.lineSeparator());
        result.append(" 1 2 3 7 8 22");
        result.append(System.lineSeparator());
        result.append(" 8 2 1 3 7 22");
        result.append(System.lineSeparator());
        result.append(" 1 2 8 22");
        result.append(System.lineSeparator());
        result.append(" 8 2 1 22");
        result.append(System.lineSeparator());

        assertEquals(result.toString(), tree.createTree(inputs));
    }
}