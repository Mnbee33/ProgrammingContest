package chapter13;

public class Tree {
    Vertex[][] table;

    Tree(int n) {
        table = new Vertex[n][n];
    }

    void add(int x, int y, Vertex vertex) {
        table[x][y] = vertex.hasCost() ? vertex : Vertex.ofEmpty();
    }

    Vertex vertex(int x, int y) {
        return table[x][y];
    }

}
