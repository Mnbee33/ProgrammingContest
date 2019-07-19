package chapter12;

public class DepthFirstSearch extends GraphSearch {
    int elapsedTime;

    DepthFirstSearch(int n) {
        super(n);
    }

    @Override
    void search() {
        for (int u = 0; u < graph.size; u++) {
            if (visitResults[u].isVisitedNotYet()) visit(u);
        }
    }

    private void visit(int u) {
        visitResults[u].setFirstVisit(++elapsedTime);
        visitRecursively(graph.metrics[u]);
        visitResults[u].setLastVisit(++elapsedTime);
    }

    private void visitRecursively(int[] metric) {
        for (int v = 0; v < graph.size; v++) {
            if (metric[v] == 0) continue;

            if (visitResults[v].isVisitedNotYet()) {
                visit(v);
            }
        }
    }

    @Override
    void appendStatus(StringBuilder result, Status status) {
        result.append(status.depthAndStatus());
        result.append(System.lineSeparator());
    }
}
