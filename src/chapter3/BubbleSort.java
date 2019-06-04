package chapter3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {
    int size;
    int count = 0;
    int[] a;

    BubbleSort(int n, int[] a) {
        size = n;
        this.a = a;
    }

    void sort() {
        boolean hasNext = true;

        while (hasNext) {
            hasNext = false;
            for (int j = size - 1; j > 0; j--) {
                // System.out.println(j);
                if (a[j] < a[j - 1]) {
                    swap(j);
                    count++;
                    hasNext = true;
                    // System.out.println(toString());
                }
            }
        }
    }

    private void swap(int j) {
        int from = a[j];
        a[j] = a[j - 1];
        a[j - 1] = from;
    }

    @Override
    public String toString() {
        String result = Arrays.stream(a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        return result + System.lineSeparator() + count;
    }
}
