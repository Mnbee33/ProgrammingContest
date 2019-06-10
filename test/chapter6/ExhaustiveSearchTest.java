package chapter6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExhaustiveSearchTest {
    @Test
    void testExhaustiveSearch() {
        int[] a = new int[]{1, 5, 7, 10, 21};
        ExhaustiveSearch search = new ExhaustiveSearch(a);
        assertFalse(search.solve(0, 2));
        assertTrue(search.solve(0, 17));
    }

    @Test
    void testExhaustiveSearchAll() {
        int[] a = new int[]{1, 5, 7, 10, 21};
        ExhaustiveSearch search = new ExhaustiveSearch(a);

        StringBuilder result = new StringBuilder();
        result.append("no");
        result.append(System.lineSeparator());
        result.append("no");
        result.append(System.lineSeparator());
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("yes");

        assertEquals(result.toString(), search.solveAll(new int[]{2, 4, 17, 8}));
    }
}
