package chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionSortTest {
    @Test
    void testSelectionSort(){
        SelectionSort sort = new SelectionSort(6, new int[]{5, 6, 4, 2, 1, 3});
        sort.sort();

        StringBuffer result = new StringBuffer();
        result.append("1 2 3 4 5 6");
        result.append(System.lineSeparator());
        result.append("4");

        assertEquals(result.toString(), sort.toString());
    }
}
