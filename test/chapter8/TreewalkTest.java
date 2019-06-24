package chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreewalkTest {
    @Test
    void testwalk() {
        Treewalk tree = new Treewalk(9);
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
        result.append("Preorder");
        result.append(System.lineSeparator());
        result.append(" 0 1 2 3 4 5 6 7 8");
        result.append(System.lineSeparator());
        result.append("Inorder");
        result.append(System.lineSeparator());
        result.append(" 2 1 3 0 6 5 7 4 8");
        result.append(System.lineSeparator());
        result.append("Postorder");
        result.append(System.lineSeparator());
        result.append(" 2 3 1 6 7 5 8 4 0");

        assertEquals(result.toString(), tree.createTreeAndWalk(inputs));
    }
}
