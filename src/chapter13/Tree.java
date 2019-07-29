package chapter13;

public class Tree {
    Vertex[][] table;

    Tree(int n) {
        table = new Vertex[n][n];
    }

    void add(Point point, Vertex vertex) {
        table[point.x][point.y] = vertex.hasCost() ? vertex : Vertex.ofEmpty();
    }

    Vertex vertex(Point point) {
        return table[point.x][point.y];
    }
}
