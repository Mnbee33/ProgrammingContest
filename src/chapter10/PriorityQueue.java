package chapter10;

import java.util.Arrays;

public class PriorityQueue {
    MaximumHeap heap;

    PriorityQueue() {
        heap = new MaximumHeap(0);
    }

    int extract() {
        int max;
        if (heap.size < 1) throw new IllegalArgumentException("ヒープに要素が格納されていません");
        max = heap.tree[1];
        heap.tree[1] = heap.tree[heap.size];
        heap.size--;
        heap.tree = Arrays.copyOf(heap.tree, heap.size + 1);
        heap.maxHeapify(1);
        return max;
    }

    void insert(int key) {
        heap.size++;
        heap.tree = Arrays.copyOf(heap.tree, heap.size + 1);
        increaseKey(heap.size, key);
    }

    void increaseKey(int i, int key) {
        if (key < heap.tree[i]) return;
        heap.tree[i] = key;
        while (i > 1 && heap.tree[i / 2] < heap.tree[i]) {
            heap.swap(i, i / 2);
        }
    }

    public String submit(String[] commandLines) {
        StringBuilder dequeues = new StringBuilder();

        boolean isOver = false;
        for (String line : commandLines) {
            if (isOver) break;

            String[] inputs = line.split(" ");
            switch (inputs[0]) {
                case "insert":
                    insert(Integer.parseInt(inputs[1]));
                    break;
                case "extract":
                    int extract = extract();
                    dequeues.append(extract);
                    dequeues.append(System.lineSeparator());
                    break;
                default:
                    isOver = true;
                    break;
            }
        }

        return dequeues.toString().trim();
    }
}
