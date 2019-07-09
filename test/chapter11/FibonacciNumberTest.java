package chapter11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciNumberTest {
    @Test
    void test() {
        FibonacciNumber f = new FibonacciNumber();

        assertEquals(3, f.get(3));
        assertEquals(1_134_903_170, f.get(44));
        assertEquals(1, f.get(0));
    }
}