package chapter7;

import chapter3.Sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Partition extends Sort {
    int baseIndex;
    int from = 0;
    int to;

    public Partition(int n, int[] a) {
        super(n, a);
        to = a.length - 1;
    }

    void partition() {
        int base = a[to];
        int smallerEnd = -1;
        for (int biggerStart = from; biggerStart < to; biggerStart++) {
            smallerEnd = moveSmallerToFront(base, smallerEnd, biggerStart);
        }
        baseIndex = smallerEnd + 1;
        swap(baseIndex, to);
    }

    private int moveSmallerToFront(int base, int smallerEnd, int biggerStart) {
        if (a[biggerStart] <= base) {
            smallerEnd++;
            swap(smallerEnd, biggerStart);
        }
        return smallerEnd;
    }

    @Override
    public String toString() {
        String result = Arrays.stream(a)
                .mapToObj(this::editIfBase)
                .collect(Collectors.joining(" "));
        return result;
    }

    private String editIfBase(int number) {
        return number == a[baseIndex] ? "[" + number + "]" : String.valueOf(number);
    }
}
