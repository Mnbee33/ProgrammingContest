package chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class MyQueue {
    int sum;
    int size;
    int limit;
    Queue<MyProcess> queue = new ArrayDeque<>();
    List<MyProcess> result = new ArrayList<>();

    MyQueue(int size, int limit) {
        this.size = size;
        this.limit = limit;
    }

    public MyQueue(String[] input) {
        String[] firstInputs = input[0].split(" ");
        size = Integer.valueOf(firstInputs[0]);
        limit = Integer.valueOf(firstInputs[1]);

        for (int i = 1; i < size + 1; i++) {
            String[] process = input[i].split(" ");
            String name = process[0];
            int time = Integer.valueOf(process[1]);
            enqueue(name, time);
        }
    }

    void enqueue(String name, int time) {
        queue.add(new MyProcess(name, time));
    }

    int size() {
        return queue.size();
    }

    MyProcess dequeue() {
        return queue.poll();
    }

    void execute(MyProcess process) {
        int remain = process.time - limit;
        if (remain > 0) {
            sum += limit;
            process.time = remain;
            queue.add(process);
        } else {
            sum += process.time;
            process.time = 0;
            process.endtime = sum;
            result.add(process);
        }
    }

    void executeAll() {
        while (!queue.isEmpty()) {
            execute(dequeue());
        }
    }


    String result() {
        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
