package chapter7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    @Test
    void testQuickSort() {
        QuickSort sort = new QuickSort(6, new String[]{
                "D 3",
                "H 2",
                "D 1",
                "S 3",
                "D 2",
                "C 1",
        });

        StringBuilder result = new StringBuilder();
        result.append("Not stable");
        result.append(System.lineSeparator());
        result.append("D 1");
        result.append(System.lineSeparator());
        result.append("C 1");
        result.append(System.lineSeparator());
        result.append("D 2");
        result.append(System.lineSeparator());
        result.append("H 2");
        result.append(System.lineSeparator());
        result.append("D 3");
        result.append(System.lineSeparator());
        result.append("S 3");
        assertEquals(result.toString(), sort.executeQuickSort());
    }
}
