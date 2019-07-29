package chapter13;

public class MinimumCosts {
    MinCostVertex[] minCosts;
    int size;

    MinimumCosts(int size) {
        this.size = size;
        minCosts = MinCostVertex.arrays(size);
    }

    int sum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            MinCostVertex vertex = minCosts[i];
            if (vertex.parent != -1) {
                sum += vertex.minCost;
            }
        }
        return sum;
    }

    MinCostVertex minVertexNotVisited() {
        MinCostVertex v = MinCostVertex.ofEmpty();
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            MinCostVertex vertex = vertex(i);
            if (minCost > vertex.minCost && vertex.isNotVisited()) {
                v = vertex;
                minCost = vertex.minCost;
            }
        }
        return v;
    }

    MinCostVertex vertex(int id) {
        return minCosts[id];
    }
}
