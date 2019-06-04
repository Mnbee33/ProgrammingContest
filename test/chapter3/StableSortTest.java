package chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StableSortTest {
    @Test
    void testStableSort() {
        StableSort sort = new StableSort(5, new String[]{"H4", "C9", "S4", "D2", "C3"});
        sort.sort();

        StringBuffer result = new StringBuffer();
        result.append("D2 C3 H4 S4 C9");
        result.append(System.lineSeparator());
        result.append("Stable");

        result.append(System.lineSeparator());

        result.append("D2 C3 S4 H4 C9");
        result.append(System.lineSeparator());
        result.append("Not stable");

        Assertions.assertEquals(result.toString(), sort.toString());
    }
}
