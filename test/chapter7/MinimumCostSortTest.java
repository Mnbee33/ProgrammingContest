package chapter7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumCostSortTest {
    @Test
    void testSort() {
        MinimumCostSort sort = new MinimumCostSort(5, new int[]{1, 5, 3, 4, 2});
        assertEquals(7, sort.solve());
    }
}
