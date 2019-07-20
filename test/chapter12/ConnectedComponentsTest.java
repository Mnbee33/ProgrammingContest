package chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectedComponentsTest {
    @Test
    void test() {
        ConnectedComponents graph = new ConnectedComponents(10);
        String[] users = {
                "0 1",
                "0 2",
                "3 4",
                "5 7",
                "5 6",
                "6 7",
                "6 8",
                "7 8",
                "8 9",
        };
        graph.createLink(users);

        String[] questions = {
                "0 1",
                "5 9",
                "1 3",
        };

        StringBuilder result = new StringBuilder();
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("yes");
        result.append(System.lineSeparator());
        result.append("no");

        assertEquals(result.toString(), graph.areConnected(questions));
    }
}