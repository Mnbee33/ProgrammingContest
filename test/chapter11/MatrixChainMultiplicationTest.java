package chapter11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixChainMultiplicationTest {
    @Test
    void test() {
        MatrixChainMultiplication m = new MatrixChainMultiplication(6);
        String[] input = {
                "30 35",
                "35 15",
                "15 5",
                "5 10",
                "10 20",
                "20 25",
        };

        assertEquals(15125, m.minCount(input));
    }
}