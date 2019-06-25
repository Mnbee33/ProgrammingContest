package chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReconstructionTreeTest {
    @Test
    void testReconstruct() {
        ReconstructionTree tree = new ReconstructionTree(5);
        assertEquals("3 4 2 5 1", tree.getPostOrder("1 2 3 4 5", "3 2 4 1 5"));
    }
}
