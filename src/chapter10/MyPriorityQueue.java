package chapter10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    private PriorityQueue<Integer> queue;

    MyPriorityQueue() {
        queue = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public String submit(String[] commandLines) {
        StringBuilder dequeue = new StringBuilder();

        boolean isOver = false;
        for (String line : commandLines) {
            if (isOver) break;
            isOver = executeCommandUntilEnd(dequeue, line.split(" "));
        }

        return dequeue.toString().trim();
    }

    boolean executeCommandUntilEnd(StringBuilder dequeue, String[] inputs) {
        switch (inputs[0]) {
            case "insert":
                queue.add(Integer.valueOf(inputs[1]));
                return false;
            case "extract":
                dequeue.append(queue.poll());
                dequeue.append(System.lineSeparator());
                return false;
            case "end":
                return true;
            default:
                return false;
        }
    }

}
