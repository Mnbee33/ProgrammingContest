package chapter6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KochCurveTest {
    @Test
    void printPoint() {
        Point point = new Point(0, 0);
        assertEquals("0.00000000 0.00000000", point.toString());
    }

    @Test
    void testKoch() {
        KochCurve koch = new KochCurve();

        StringBuilder result = new StringBuilder();
        result.append("0.00000000 0.00000000");
        result.append(System.lineSeparator());
        result.append("33.33333333 0.00000000");
        result.append(System.lineSeparator());
        result.append("50.00000000 28.86751346");
        result.append(System.lineSeparator());
        result.append("66.66666667 0.00000000");
        result.append(System.lineSeparator());
        result.append("100.00000000 0.00000000");

        assertEquals(result.toString(), koch.kochCurve(1));
    }
}
