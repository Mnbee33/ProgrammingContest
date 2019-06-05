package chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    final String line = "1 2 + 3 4 - *";

    @Test
    void testStack() {
        MyStack stack = new MyStack();
        assertEquals(7, stack.splitLine(line).length);

        stack.push(1);
        stack.push(2);
        assertEquals(1, stack.numbers[0]);
        assertEquals(2, stack.numbers[1]);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.size);

        assertEquals(3, stack.parse(new String[]{"1", "2", "+"}));
        assertEquals(-1, stack.parse(new String[]{"1", "2", "-"}));
        assertEquals(2, stack.parse(new String[]{"1", "2", "*"}));

        assertEquals(-3, stack.calculate(line));

        assertEquals(-3, stack.calculateByDefaultStack(line));
    }
}
