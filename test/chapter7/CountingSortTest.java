package chapter7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingSortTest {
    @Test
    void testCountingSort() {
        CountingSort sort = new CountingSort(7,
                new int[]{2, 5, 1, 3, 2, 3, 0});
        sort.sort();
        assertEquals("0 1 2 2 3 3 5", sort.toString());
    }
}
