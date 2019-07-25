package chapter13;

import chapter12.VisitStatus;

public class MinCostVertex {
    int id;
    int minCost;
    int parent;
    VisitStatus status;

    static MinCostVertex of(int id, int cost, int parent, VisitStatus status) {
        MinCostVertex node = new MinCostVertex();
        node.id = id;
        node.set(cost, parent, status);
        return node;
    }

    static MinCostVertex of(int id) {
        return of(id, Integer.MAX_VALUE, -1, VisitStatus.NOT_YET);
    }

    static MinCostVertex ofEmpty() {
        return of(-1);
    }

    void set(int cost, int parent, VisitStatus status) {
        this.minCost = cost;
        this.parent = parent;
        this.status = status;
    }

    static MinCostVertex[] array(int size) {
        MinCostVertex[] vertexArray = new MinCostVertex[size];
        for (int i = 0; i < size; i++) {
            vertexArray[i] = of(i);
        }
        return vertexArray;
    }

    boolean isNotVisited() {
        return !status.equals(VisitStatus.VISITED);
    }

    boolean isEmpty() {
        return id == -1;
    }
}
