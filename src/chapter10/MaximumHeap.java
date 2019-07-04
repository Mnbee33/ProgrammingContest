package chapter10;

public class MaximumHeap {
    int size;
    int[] tree;

    MaximumHeap(int n) {
        size = n;
        tree = new int[size + 1];
    }

    String create(String commandLine) {
        String[] keys = commandLine.split(" ");
        createTree(keys);
        heapify();
        return writeTree();
    }

    private void createTree(String[] keys) {
        for (int i = 1; i <= size; i++) {
            tree[i] = Integer.valueOf(keys[i - 1]);
        }
    }

    private void heapify() {
        for (int i = 1; i <= size; i++) {
            maxHeapify(tree[i]);
        }
    }

    private String writeTree() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            result.append(tree[i] + " ");
        }
        return result.toString().trim();
    }

    void maxHeapify(int i) {
        int largest = largestKey(i);

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private int largestKey(int i) {
        int largest = i;
        largest = larger(largest, left(i));
        largest = larger(largest, right(i));
        return largest;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private int larger(int source, int compared) {
        return isLarger(compared, source) ? compared : source;
    }

    private boolean isLarger(int source, int compared) {
        return (source <= size) && (tree[source] > tree[compared]);
    }

    private void swap(int fromIndex, int toIndex) {
        int temp = tree[fromIndex];
        tree[fromIndex] = tree[toIndex];
        tree[toIndex] = temp;
    }
}
