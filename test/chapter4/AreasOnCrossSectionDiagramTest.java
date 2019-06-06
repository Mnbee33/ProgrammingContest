package chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreasOnCrossSectionDiagramTest {
    @Test
    void testStackPush() {
        DiagramArea area = new DiagramArea();
        area.diagram("\\\\");
        assertEquals(1, area.depths.pop());
        assertEquals(0, area.depths.pop());
    }

    @Test
    void testCalculateArea() {
        DiagramArea area = new DiagramArea();
        area.diagram("\\\\//");
        MyPool pool = area.pools.pop();
        assertEquals(0, pool.from);
        assertEquals(4, pool.area);
        assertEquals(4, area.sum);
    }

    @Test
    void testPrintResult() {
        DiagramArea area = new DiagramArea();
        area.diagram("\\\\///\\\\_/\\/");

        StringBuilder result = new StringBuilder();
        result.append("7");
        result.append(System.lineSeparator());
        result.append("3 4 2 1");
        assertEquals(7, area.sum);
        assertEquals(result.toString(), area.toString());

        area = new DiagramArea();
        area.diagram("\\\\///\\_/\\/\\\\\\\\/_/\\\\///__\\\\\\_\\\\/_\\/_/\\");
        result = new StringBuilder();
        result.append("35");
        result.append(System.lineSeparator());
        result.append("5 4 2 1 19 9");
        assertEquals(result.toString(), area.toString());
    }
}
