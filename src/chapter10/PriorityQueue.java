package chapter10;

public class PriorityQueue {
    MaximumHeap heap;

    PriorityQueue() {
        heap = new MaximumHeap(0);
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
                insert(Integer.parseInt(inputs[1]));
                return false;
            case "extract":
                dequeue.append(extract());
                dequeue.append(System.lineSeparator());
                return false;
            case "end":
                return true;
            default:
                return false;
        }
    }

    void insert(int key) {
        heap.sizeUp();
        heap.resize();
        increaseKey(heap.size, key);
    }

    void increaseKey(int i, int key) {
        if (key < heap.get(i)) return;
        heap.set(i, key);
        swapToParent(i);
    }

    private void swapToParent(int i) {
        int parent = i / 2;
        while (i > 1 && heap.get(parent) < heap.get(i)) {
            heap.swap(i, parent);
        }
    }

    int extract() {
        if (heap.size < 1) throw new IllegalArgumentException("ヒープに要素が格納されていません");
        int max = heap.getFirstNode();
        removeFirstNode();
        return max;
    }

    private void removeFirstNode() {
        heap.set(1, heap.getLastNode());
        heap.sizeDown();
        heap.resize();
        heap.maxHeapify(1);
    }
}
