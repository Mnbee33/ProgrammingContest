package chapter12;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch extends GraphSearch {

    BreadthFirstSearch(int n) {
        super(n);
    }

    @Override
    void search() {
        Queue<Integer> queue = new ArrayDeque<>();
        setRoot(queue);
        visitAll(queue);
    }

    private void setRoot(Queue<Integer> queue) {
        int root = 0;
        queue.add(root);
        visitResults[root].distance = 0;
    }

    private void visitAll(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            visitAdjacentNode(queue);
        }
    }

    private void visitAdjacentNode(Queue<Integer> queue) {
        int visited = queue.poll();
        for (int v = 0; v < graph.size; v++) {
            Status visiting = visitResults[v];
            if (graph.isNotAdjacent(visited, v)) continue;
            if (visiting.isAnyDistance()) continue;
            visiting.distance = visitResults[visited].distance + 1;
            queue.add(v);
        }
    }

    @Override
    void appendStatus(StringBuilder result, Status status) {
        String output = status.distance();
        result.append(output);
        result.append(System.lineSeparator());
    }

}
