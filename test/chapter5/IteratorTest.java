package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IteratorTest {
    @Test
    void testIterator() {
        MyIterator iterator = new MyIterator();
        assertEquals("2014", iterator.trim("2 0 1 4"));
    }
}
