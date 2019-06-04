package chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumProfitTest {
    @Test
    void testMaximumProfit() {
        MaximumProfit profit = new MaximumProfit(new int[]{6, 5, 3, 1, 3, 4, 3});
        Assertions.assertEquals(3, profit.maximumProfit());

        profit = new MaximumProfit(new int[]{3, 4, 3, 2});
        Assertions.assertEquals(-1, profit.maximumProfit());
    }
}