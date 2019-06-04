package chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {
    @Test
    void testBubbleSort(){
        BubbleSort sort = new BubbleSort(5, new int[]{5, 3, 2, 4, 1});

        StringBuffer result = new StringBuffer();
        result.append("1 2 3 4 5");
        result.append(System.lineSeparator());
        result.append("8");

        sort.sort();
        Assertions.assertEquals(result.toString(), sort.toString());
    }
}
