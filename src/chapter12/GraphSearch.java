package chapter12;

public abstract class GraphSearch {
    AdjacencyList graph;
    Status[] visitResults;

    GraphSearch(int n) {
        graph = new AdjacencyList(n);
        visitResults = Status.getArray(graph.size);
    }

    void createGraph(String[] lines) {
        graph.setNodes(lines);
    }

    String searchAll() {
        search();
        return printAll();
    }

    abstract void search();

    String printAll() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < graph.size; i++) {
            appendStatus(result, visitResults[i]);
        }
        return result.toString().trim();
    }

    abstract void appendStatus(StringBuilder result, Status visitResult);
}
