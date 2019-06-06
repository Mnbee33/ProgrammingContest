package chapter4;

public class MyPool {
    int from;
    int area;

    MyPool(int from, int area) {
        this.from = from;
        this.area = area;
    }

    boolean isFarPoint(int point) {
        return from > point;
    }
}
