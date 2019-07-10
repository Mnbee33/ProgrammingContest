package chapter11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceTest {
    @Test
    void testLcs() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence(3);
        String[] inputs = {
                "abcbdab",
                "bdcaba",
                "abc",
                "abc",
                "abc",
                "bc",
        };

        StringBuilder result = new StringBuilder();
        result.append(4);
        result.append(System.lineSeparator());
        result.append(3);
        result.append(System.lineSeparator());
        result.append(2);

        assertEquals(result.toString(), lcs.checkPairLines(inputs));
    }
}