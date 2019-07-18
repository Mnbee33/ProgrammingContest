package chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepthFirstSearchTest {
    @Test
    void testDepthFirstSearch() {
        DepthFirstSearch search = new DepthFirstSearch(6);
        String[] input = {
                "1 2 2 3",
                "2 2 3 4",
                "3 1 5",
                "4 1 6",
                "5 1 6",
                "6 0",
        };
        search.createGraph(input);

        StringBuilder result = new StringBuilder();
        result.append("1 1 12");
        result.append(System.lineSeparator());
        result.append("2 2 11");
        result.append(System.lineSeparator());
        result.append("3 3 8");
        result.append(System.lineSeparator());
        result.append("4 9 10");
        result.append(System.lineSeparator());
        result.append("5 4 7");
        result.append(System.lineSeparator());
        result.append("6 5 6");

        assertEquals(result.toString(), search.searchAll());
    }
}