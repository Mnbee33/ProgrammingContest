package chapter12;

public class DepthFirstSearch {
    AdjacencyList graph;
    Status[] visitResult;
    int elapsedTime;

    DepthFirstSearch(int n) {
        graph = new AdjacencyList(n);
        visitResult = new Status[n];
        initStatusForNodes();
    }

    private void initStatusForNodes() {
        for (int u = 0; u < graph.size; u++) {
            visitResult[u] = new Status(u + 1);
        }
    }

    void createGraph(String[] lines) {
        graph.setNodes(lines);
    }

    String searchAll() {
        depthFirstSearch();
        return printAll();
    }

    private void depthFirstSearch() {
        for (int u = 0; u < graph.size; u++) {
            if (visitResult[u].isVisitedNotYet()) visit(u);
        }
    }

    private void visit(int u) {
        visitResult[u].setFirstVisit(++elapsedTime);
        visitRecursively(graph.metrics[u]);
        visitResult[u].setLastVisit(++elapsedTime);
    }

    private void visitRecursively(int[] metric) {
        for (int v = 0; v < graph.size; v++) {
            if (metric[v] == 0) continue;

            if (visitResult[v].isVisitedNotYet()) {
                visit(v);
            }
        }
    }

    private String printAll() {
        StringBuilder result = new StringBuilder();
        for (int u = 0; u < graph.size; u++) {
            appendSearchResult(result, u);
        }
        return result.toString().trim();
    }

    private void appendSearchResult(StringBuilder result, int u) {
        result.append(visitResult[u]);
        result.append(System.lineSeparator());
    }
}
