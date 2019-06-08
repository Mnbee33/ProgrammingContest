package chapter5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraysBinarySearchTest {
    @Test
    void test() {
        int[] a = new int[]{1, 1, 2, 2, 2, 4, 5, 5, 6, 8, 8, 8, 10, 15};
        int index = Arrays.binarySearch(a, 4);
        String result = new Formatter().format("A[%d] = %d", index, 4).toString();
        assertEquals("A[5] = 4", result);
    }

    @Test
    void testArraysBinarySearch() {
        BinarySearch search = new ArraysBinarySearch(5, new Integer[]{1, 2, 3, 4, 5});
        assertEquals(3, search.countMatch(new Integer[]{3, 4, 1, 7}));
    }
}
