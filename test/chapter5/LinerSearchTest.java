package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinerSearchTest {
    @Test
    void testLinerSearchTest() {
        LinerSearch search = new LinerSearch(5, new Integer[]{1, 2, 3, 4, 5});
        assertEquals(5, search.listEnd());

        search.setSearchTarget(6);
        assertEquals(6, search.listEnd());

        assertFalse(search.isFoundByLinerSearch(6));
        assertTrue(search.isFoundByLinerSearch(5));

        assertFalse(search.isFound(7));
        assertTrue(search.isFound(2));
    }

    @Test
    void testLinerSearchAll() {
        LinerSearch search = new LinerSearch(5, new Integer[]{1, 2, 3, 4, 5});
        assertEquals(3, search.countMatch(new Integer[]{3, 4, 1, 7}));
    }
}
