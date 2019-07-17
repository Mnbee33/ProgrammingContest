package chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdjacencyListTest {
    @Test
    void testLine() {
        AdjacencyList graph = new AdjacencyList(4);
        graph.setNode(0, "1 2 2 4");
        assertEquals("0 1 0 1", graph.printNode(0));
    }

    @Test
    void testAll() {
        AdjacencyList graph = new AdjacencyList(4);
        graph.setNodes(new String[]{
                "1 2 2 4",
                "2 1 4",
                "3 0",
                "4 1 3",
        });

        StringBuilder result = new StringBuilder();
        result.append("0 1 0 1");
        result.append(System.lineSeparator());
        result.append("0 0 0 1");
        result.append(System.lineSeparator());
        result.append("0 0 0 0");
        result.append(System.lineSeparator());
        result.append("0 0 1 0");

        assertEquals(result.toString(), graph.printAll());
    }
}