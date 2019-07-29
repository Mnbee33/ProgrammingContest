package chapter13;

import chapter12.VisitStatus;

public class MinimumSpanningTree {
    int size;
    Tree tree;

    MinimumSpanningTree(int n) {
        size = n;
        tree = new Tree(n);
    }

    int main(String[] lines) {
        createTree(lines);
        return prim();
    }

    private void createTree(String[] lines) {
        for (int i = 0; i < size; i++) {
            String[] inputs = lines[i].split(" ");
            for (int j = 0; j < size; j++) {
                int cost = Integer.parseInt(inputs[j]);
                tree.add(Point.of(i, j), Vertex.of(cost));
            }
        }
    }

    int prim() {
        MinimumCosts minCosts = new MinimumCosts(size);
        visitAll(minCosts);
        return minCosts.sum();
    }

    private void visitAll(MinimumCosts costs) {
        costs.vertex(0).minCost = 0;
        while (true) {
            MinCostVertex minv = costs.minVertexNotVisited();

            if (minv.isEmpty()) {
                break;
            }

            minv.status = VisitStatus.VISITED;
            visitAdjacency(minv, costs);
        }
    }

    void visitAdjacency(MinCostVertex parent, MinimumCosts costs) {
        for (int v = 0; v < size; v++) {
            Vertex adjacent = tree.vertex(Point.of(parent.id, v));
            MinCostVertex min = costs.vertex(v);
            min.visitMinVertex(adjacent);
        }
    }
}
