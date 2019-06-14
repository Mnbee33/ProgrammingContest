package chapter7;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {
    private int[] a;
    private int size;
    private final int MAX = 500000;
    private final int SENTINEL = 2000000000;    // sentinel = 番兵
    private int[] leftList;
    private int[] rightList;
    int mergeCount;

    public MergeSort(int n, int[] a) {
        size = n;
        this.a = a;
    }

    public String solve() {
        divideAndMergeSort(0, size);
        StringBuilder result = createResult();
        return result.toString();
    }

    void divideAndMergeSort(int left, int right) {
        if (left + 1 < right) {
            int middle = (left + right) / 2;
            divideAndMergeSort(left, middle);
            divideAndMergeSort(middle, right);
            mergeSort(left, middle, right);
        }
    }

    void mergeSort(int left, int middle, int right) {
        int leftSize = middle - left;
        int rightSize = right - middle;

        leftList = createPartList(left, leftSize);
        rightList = createPartList(middle, rightSize);

        merge(left, right);
    }

    private int[] createPartList(int from, int size) {
        int[] list = new int[size + 1];
        for (int i = 0; i < size; i++) {
            list[i] = a[from + i];
        }
        list[size] = SENTINEL;
        return list;
    }


    private void merge(int left, int right) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int k = left; k < right; k++) {
            mergeCount++;
            if (leftList[leftIndex] <= rightList[rightIndex]) {
                a[k] = leftList[leftIndex++];
            } else {
                a[k] = rightList[rightIndex++];
            }
        }
    }

    StringBuilder createResult() {
        StringBuilder result = new StringBuilder();
        String resultLine = Arrays.stream(a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        result.append(resultLine);
        result.append(System.lineSeparator());
        result.append(mergeCount);
        return result;
    }
}
