package chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumHeapTest {

    @Test
    void testCreateTree() {
        MaximumHeap heap = new MaximumHeap(10);
        assertEquals("16 14 10 8 7 9 3 2 4 1", heap.create("4 1 3 2 16 9 10 14 8 7"));
    }
}