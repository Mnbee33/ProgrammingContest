package chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriorityQueueTest {
    @Test
    void test() {
        PriorityQueue queue = new PriorityQueue();
        String[] inputs = {
                "insert 8",
                "insert 2",
                "extract",
                "insert 10",
                "extract",
                "insert 11",
                "extract",
                "extract",
                "end",
        };

        StringBuilder result = new StringBuilder();
        result.append(8);
        result.append(System.lineSeparator());
        result.append(10);
        result.append(System.lineSeparator());
        result.append(11);
        result.append(System.lineSeparator());
        result.append(2);

        assertEquals(result.toString(), queue.submit(inputs));
    }
}