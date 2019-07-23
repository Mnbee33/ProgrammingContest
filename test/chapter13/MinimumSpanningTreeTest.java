package chapter13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSpanningTreeTest {
    @Test
    void testPrim() {
        MinimumSpanningTree tree = new MinimumSpanningTree(5);
        String[] inputs = {
                "-1 2 3 1 -1",
                "2 -1 -1 4 -1",
                "3 -1 -1 1 1",
                "1 4 1 -1 3",
                "-1 -1 1 3 -1"
        };

        assertEquals(5, tree.main(inputs));
    }
}