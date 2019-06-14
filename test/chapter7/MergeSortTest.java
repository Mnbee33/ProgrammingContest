package chapter7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTest {
    @Test
    void testMerge() {
        MergeSort sort = new MergeSort(10,
                new int[]{8, 5, 9, 2, 6, 3, 7, 1, 10, 4,
                });
        StringBuilder result = new StringBuilder();
        result.append("1 2 3 4 5 6 7 8 9 10");
        result.append(System.lineSeparator());
        result.append("34");
        assertEquals(result.toString(), sort.solve());
    }
}
