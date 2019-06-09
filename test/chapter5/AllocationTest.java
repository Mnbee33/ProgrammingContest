package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllocationTest {
    @Test
    void testAllocate() {
        int[] baggage = new int[]{8, 1, 7, 3, 9};
        int numberOfTrucks = 3;
        Allocation al = new Allocation(baggage, numberOfTrucks);
        assertEquals(5, al.allocate(10));
    }

    @Test
    void testSolve() {
        int[] baggage = new int[]{8, 1, 7, 3, 9};
        int numberOfTrucks = 3;
        Allocation al = new Allocation(baggage, numberOfTrucks);
        assertEquals(10, al.solve());

    }
}
