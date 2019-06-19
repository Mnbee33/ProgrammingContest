package chapter7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InversionTest {
    @Test
    void testInversion() {
        Inversion sort = new Inversion(6, new int[]{5, 3, 6, 2, 1, 4});
        assertEquals(10, sort.solve());

        sort = new Inversion(5, new int[]{3, 5, 2, 1, 4});
        assertEquals(6, sort.solve());
    }
}
