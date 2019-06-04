package chapter3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sort {
    int size;
    int[] a;
    int count;

    Sort(int n, int[] a) {
        size = n;
        this.a = a;
    }

    void swap(int fromIndex, int toIndex) {
        int temp = a[fromIndex];
        a[fromIndex] = a[toIndex];
        a[toIndex] = temp;
    }

    @Override
    public String toString() {
        String result = Arrays.stream(a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        return result + System.lineSeparator() + count;
    }
}
