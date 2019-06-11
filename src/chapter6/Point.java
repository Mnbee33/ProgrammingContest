package chapter6;

import java.util.Formatter;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    @Override
    public String toString() {
        return new Formatter().format("%.8f %.8f", x, y).toString();
    }
}
