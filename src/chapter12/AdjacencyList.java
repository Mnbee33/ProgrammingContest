package chapter12;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AdjacencyList {
    int[][] metrics;
    int size;

    AdjacencyList(int n) {
        size = n;
        metrics = new int[size][size];
    }

    void setNodes(String[] lines) {
        for (int i = 0; i < size; i++) {
            String line = lines[i];
            setNode(i, line);
        }
    }

    void setNode(int node, String line) {
        int[] input = convertToNumbers(line);
        int count = input[1];
        for (int i = 0; i < size; i++) {
            setAdjacencyNode(node, input, count);
        }
    }

    private void setAdjacencyNode(int node, int[] input, int count) {
        for (int j = 0; j < count; j++) {
            int adjacentNode = getNode(j + 2, input);
            metrics[node][adjacentNode] = 1;
        }
    }

    private int[] convertToNumbers(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int getNode(int i, int[] input) {
        return input[i] - 1;
    }

    String printAll() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(printNode(i));
            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    String printNode(int node) {
        int[] aNode = metrics[node];
        return Arrays.stream(aNode)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
