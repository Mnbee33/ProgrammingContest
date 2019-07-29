package chapter13;

public class Vertex {
    int cost;

    boolean hasCost() {
        return cost != Integer.MAX_VALUE && cost != -1;
    }

    Vertex(int cost) {
        this.cost = cost;
    }

    static Vertex ofEmpty() {
        return new Vertex(Integer.MAX_VALUE);
    }
}