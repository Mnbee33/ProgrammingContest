package chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BreadthFirstSearchTest {
    @Test
    void testSearch() {
        BreadthFirstSearch graph = new BreadthFirstSearch(4);
        String[] input = {
                "1 2 2 4",
                "2 1 4",
                "3 0",
                "4 1 3",
        };
        graph.createGraph(input);

        StringBuilder result = new StringBuilder();
        result.append("1 0");
        result.append(System.lineSeparator());
        result.append("2 1");
        result.append(System.lineSeparator());
        result.append("3 2");
        result.append(System.lineSeparator());
        result.append("4 1");
        assertEquals(result.toString(), graph.searchAll());
    }
}