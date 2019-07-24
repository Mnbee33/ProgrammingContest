package chapter13;

import chapter12.VisitStatus;

public class MinimumSpanningTree {
    int size;
    Tree tree;

    class Node {
        int x;
        int y;
        int cost;

        boolean hasCost() {
            return cost != Integer.MAX_VALUE;
        }
    }

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
                tree.add(i, j, cost);
            }
        }
    }

    int prim() {
        Vertex[] nodes = Vertex.array(size);
        visitAll(nodes);
        return sumCost(nodes);
    }

    private void visitAll(Vertex[] nodes) {
        nodes[0].minCost = 0;
        while (true) {
            int minVertex = vertexHasMinCost(nodes);

            if (isNoCost(minVertex)) {
                break;
            }

            nodes[minVertex].status = VisitStatus.VISITED;

            for (int v = 0; v < size; v++) {
                Vertex node = nodes[v];
                int cost = tree.cost(minVertex, v);

                if (node.isNotVisited() && cost != Integer.MAX_VALUE) {
                    if (node.minCost > cost) {
                        node.set(cost, minVertex, VisitStatus.VISITING);
                    }
                }
            }
        }
    }

    private int vertexHasMinCost(Vertex[] nodes) {
        int u = -1;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            Vertex vertex = nodes[i];
            if (minCost > vertex.minCost && vertex.isNotVisited()) {
                u = i;
                minCost = vertex.minCost;
            }
        }
        return u;
    }

    private boolean isNoCost(int minVertex) {
        return minVertex == -1;
    }

    private int sumCost(Vertex[] nodes) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Vertex node = nodes[i];
            if (node.parent != -1) {
                sum += tree.cost(i, node.parent);
            }
        }
        return sum;
    }
}
