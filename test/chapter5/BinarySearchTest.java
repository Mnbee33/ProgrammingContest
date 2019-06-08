package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    @Test
    void testMiddle() {
        BinarySearch search = new BinarySearch(5, new Integer[]{1, 2, 3, 4, 5});
        assertEquals(2, search.middle(0, 5));
    }

    @Test
    void testBinarySearchOnce() {
        BinarySearch search = new BinarySearch(5, new Integer[]{1, 2, 3, 4, 5});
        assertFalse(search.isFound(7));
        assertTrue(search.isFound(2));
    }

    @Test
    void testBinarySearchAll() {
        BinarySearch search = new BinarySearch(5, new Integer[]{1, 2, 3, 4, 5});
        assertEquals(3, search.countMatch(new Integer[]{3, 4, 1, 7}));
    }
}
