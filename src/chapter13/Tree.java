package chapter13;

public class Tree {
    int[][] metrics;

    Tree(int n) {
        metrics = new int[n][n];
    }

    void add(int x, int y, int cost) {
        metrics[x][y] = (isNoCost(cost) ? Integer.MAX_VALUE : cost);
    }

    int cost(int x, int y) {
        return metrics[x][y];
    }

    private boolean isNoCost(int minVertex) {
        return minVertex == -1;
    }
}
