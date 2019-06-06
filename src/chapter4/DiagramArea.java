package chapter4;

import java.util.Stack;

public class DiagramArea {
    Stack<MyPool> pools = new Stack<>();
    Stack<Integer> depths = new Stack<>();
    int sum = 0;

    public void diagram(String line) {

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            setDepth(i, c);
            calculateArea(i, c);
        }
    }

    private void setDepth(int depth, char c) {
        if (c == '\\') {
            depths.push(depth);
        }
    }

    private void calculateArea(int i, char c) {
        if (c == '/' && !depths.isEmpty()) {
            int j = depths.pop();
            int area = i - j;
            sum += area;
            while (IsInTheMiddleOfTheSlope(j)) {
                area += pools.pop().area;
            }
            pools.push(new MyPool(j, area));
        }
    }

    private boolean IsInTheMiddleOfTheSlope(int point) {
        return !pools.isEmpty() && pools.peek().isFarPoint(point);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(sum);
        result.append(System.lineSeparator());

        result.append(pools.size());
        result.append(" ");
        for (MyPool pool : pools) {
            result.append(pool.area);
            result.append(" ");
        }
        return result.toString().trim();
    }
}
