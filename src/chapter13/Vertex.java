package chapter13;

public class Vertex {
    int cost;

    boolean hasCost() {
        return cost != Integer.MAX_VALUE && cost != -1;
    }

    static Vertex of(int cost) {
        Vertex v = new Vertex();
        v.cost = cost;
        return v;
    }

    static Vertex ofEmpty() {
        return of(Integer.MAX_VALUE);
    }
}