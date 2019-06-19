package chapter7;

public class Inversion {
    private int[] a;
    private int size;
    private final int MAX = 500000;
    private final int SENTINEL = 2000000000;    // sentinel = 番兵
    private int[] leftList;
    private int[] rightList;

    public Inversion(int n, int[] a) {
        size = n;
        this.a = a;
    }

    public int solve() {
        return divideAndMergeSort(0, size);
    }

    int divideAndMergeSort(int left, int right) {
        if (left + 1 < right) {
            int middle = (left + right) / 2;
            int leftChanges = divideAndMergeSort(left, middle);
            int rightChanges = divideAndMergeSort(middle, right);
            int mergeChanges = mergeSort(left, middle, right);
            // System.out.println(String.format("%d, %d, %d", leftChanges, rightChanges, mergeChanges));
            return leftChanges + rightChanges + mergeChanges;
        }
        return 0;
    }

    int mergeSort(int left, int middle, int right) {
        int leftSize = middle - left;
        int rightSize = right - middle;

        leftList = createPartList(left, leftSize);
        rightList = createPartList(middle, rightSize);

        return merge(left, right, leftSize);
    }

    private int[] createPartList(int from, int size) {
        int[] list = new int[size + 1];
        for (int i = 0; i < size; i++) {
            list[i] = a[from + i];
        }
        list[size] = SENTINEL;
        return list;
    }

    private int merge(int left, int right, int leftSize) {
        int leftIndex = 0;
        int rightIndex = 0;
        int changes = 0;
        for (int k = left; k < right; k++) {
            if (leftList[leftIndex] <= rightList[rightIndex]) {
                a[k] = leftList[leftIndex++];
            } else {
                a[k] = rightList[rightIndex++];
                changes += leftSize - leftIndex;
            }
        }
        return changes;
    }
}
