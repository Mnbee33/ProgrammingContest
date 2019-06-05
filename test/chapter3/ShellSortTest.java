package chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShellSortTest {
    @Test
    void testStableSort() {
        ShellSort sort = new ShellSort(5, new int[]{5, 1, 4, 3, 2});
        sort.sort();

        StringBuffer result = new StringBuffer();
        result.append("2");
        result.append(System.lineSeparator());
        result.append("4 1");
        result.append(System.lineSeparator());
        result.append("3");
        result.append(System.lineSeparator());
        result.append("1,2,3,4,5");

        Assertions.assertEquals(result.toString(), sort.toString());
    }
}
