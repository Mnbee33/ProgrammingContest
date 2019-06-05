package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShellSort extends Sort {
    int count;
    List<Integer> g = new ArrayList<>();

    ShellSort(int n, int[] a) {
        super(n, a);
    }

    public void sort() {
        setG();
        for (Integer gValue : g) {
            insertionSort(gValue);
        }
    }

    void setG() {
        int h = 1;
        while (h <= size) {
            g.add(Integer.valueOf(h));
            h = 3 * h + 1;
        }
        Collections.reverse(g);
    }

    void insertionSort(int g) {
        for (int i = g; i < size; i++) {
            int value = a[i];
            int j = i - g;
            while (j >= 0 && a[j] > value) {
                a[j + g] = a[j];
                j = j - g;
                count++;
            }
            a[j + g] = value;
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(g.size());
        result.append(System.lineSeparator());
        result.append(g.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        result.append(System.lineSeparator());
        result.append(count);
        result.append(System.lineSeparator());
        result.append(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        return result.toString();
    }
}
