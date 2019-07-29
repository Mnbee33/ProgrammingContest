package chapter13;

import chapter12.VisitStatus;

public class MinCostVertex {
    int id;
    int minCost;
    int parent;
    VisitStatus status;

    MinCostVertex(int id) {
        this.id = id;
        minCost = Integer.MAX_VALUE;
        parent = -1;
        status = VisitStatus.NOT_YET;
    }

    static MinCostVertex ofEmpty() {
        return new MinCostVertex(-1);
    }

    static MinCostVertex[] of(int size) {
        MinCostVertex[] vertexArray = new MinCostVertex[size];
        for (int i = 0; i < size; i++) {
            vertexArray[i] = new MinCostVertex(i);
        }
        return vertexArray;
    }

    boolean isNotVisited() {
        return !status.equals(VisitStatus.VISITED);
    }

    boolean isEmpty() {
        return id == -1;
    }

    void visitMinVertex(Vertex vertex) {
        if (isNotVisited() && vertex.hasCost()) {
            if (minCost > vertex.cost) {
                minCost = vertex.cost;
                parent = id;
                status = VisitStatus.VISITING;
            }
        }
    }
}
