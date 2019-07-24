package chapter13;

import chapter12.VisitStatus;

import java.util.stream.Stream;

public class Vertex {
    int minCost;
    int parent;
    VisitStatus status;

    static Vertex of(int cost, int parent, VisitStatus status) {
        Vertex node = new Vertex();
        node.set(cost, parent, status);
        return node;
    }

    static Vertex of() {
        return of(Integer.MAX_VALUE, -1, VisitStatus.NOT_YET);
    }

    void set(int cost, int parent, VisitStatus status) {
        this.minCost = cost;
        this.parent = parent;
        this.status = status;
    }

    static Vertex[] array(int size) {
        return Stream.generate(Vertex::of)
                .limit(size)
                .toArray(Vertex[]::new);
    }

    boolean isNotVisited() {
        return !status.equals(VisitStatus.VISITED);
    }
}
