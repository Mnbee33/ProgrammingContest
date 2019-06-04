package chapter3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;


public class InsertionSortTest {
    @Test
    void testInsertSort() {
        InsertSort sort = new InsertSort(6, new int[]{5,2,4,6,1,3});

        StringBuffer result = new StringBuffer();
        result.append("5 2 4 6 1 3");
        result.append(System.lineSeparator());
        result.append("2 5 4 6 1 3");
        result.append(System.lineSeparator());
        result.append("2 4 5 6 1 3");
        result.append(System.lineSeparator());
        result.append("2 4 5 6 1 3");
        result.append(System.lineSeparator());
        result.append("1 2 4 5 6 3");
        result.append(System.lineSeparator());
        result.append("1 2 3 4 5 6");

        assertEquals(result.toString(), sort.sort());
    }
}
