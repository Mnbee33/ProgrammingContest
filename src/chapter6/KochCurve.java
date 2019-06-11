package chapter6;

public class KochCurve {
    int depth;
    Point from;
    Point to;
    final double radians = Math.toRadians(60);
    StringBuilder result = new StringBuilder();

    void koch(Point from, Point to) {
        if (depth == 0) return;

        Point left = createLeftPoint();
        Point right = createRightPoint();
        Point middle = setMiddlePoint(left, right);

        depth = depth - 1;
        calculatePoint(left, from);
        calculatePoint(middle, left);
        calculatePoint(right, middle);
        koch(right, to);
    }

    private void calculatePoint(Point target, Point from) {
        koch(from, target);
        setResult(target);
    }

    private Point setMiddlePoint(Point left, Point right) {
        double x = (right.x - left.x) * Math.cos(radians) - (right.y - left.y) * Math.sin(radians) + left.x;
        double y = (right.x - left.x) * Math.sin(radians) + (right.y - left.y) * Math.cos(radians) + left.y;
        return new Point(x, y);
    }

    private Point createRightPoint() {
        return createPoint(from, to, 1.0, 2);
    }

    private Point createLeftPoint() {
        return createPoint(from, to, 2.0, 1);
    }

    private Point createPoint(Point from, Point to, double v, int i) {
        double x = (v * from.x + i * to.x) / 3.0;
        double y = (v * from.y + i * to.y) / 3.0;
        return new Point(x, y);
    }

    String kochCurve(int i) {
        depth = i;
        from = new Point(0, 0);
        to = new Point(100, 0);

        setResult(from);
        koch(from, to);
        setResult(to);

        return result.toString().trim();
    }

    private void setResult(Point point) {
        result.append(point.toString());
        result.append(System.lineSeparator());
    }
}
