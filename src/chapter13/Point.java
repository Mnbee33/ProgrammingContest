package chapter13;

public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Point of(int x, int y) {
        return new Point(x, y);
    }
}
