package chapter7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartitionTest {
    @Test
    void testPartitionSort() {
        Partition sort = new Partition(12, new int[]{
                13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11
        });
        sort.partition();
        assertEquals("9 5 8 7 4 2 6 [11] 21 13 19 12", sort.toString());
    }
}
