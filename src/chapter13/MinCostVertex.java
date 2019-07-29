package chapter13;

import chapter12.VisitStatus;

public class MinCostVertex {
    int id;
    int minCost;
    int parent;
    VisitStatus status;

    static class Builder {

        final int id;

        int cost = Integer.MAX_VALUE;
        int parent = -1;

        VisitStatus status = VisitStatus.NOT_YET;

        Builder(int id) {
            this.id = id;
        }

        Builder cost(int value) {
            cost = value;
            return this;
        }

        Builder parent(int value) {
            parent = value;
            return this;
        }

        Builder status(VisitStatus value) {
            status = value;
            return this;
        }

        MinCostVertex build() {
            return new MinCostVertex(this);
        }
    }

    MinCostVertex(Builder builder) {
        id = builder.id;
        minCost = builder.cost;
        parent = builder.parent;
        status = builder.status;
    }

    static MinCostVertex of(int id) {
        Builder builder = new Builder(id);
        return builder.build();
    }

    static MinCostVertex ofEmpty() {
        return of(-1);
    }

    static MinCostVertex[] arrays(int size) {
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
